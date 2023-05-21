package com.xquare.v2servicereport.common.error

import com.fasterxml.jackson.databind.ObjectMapper
import com.xquare.v2servicereport.common.exceptions.InternalServerErrorException
import io.sentry.Sentry
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ErrorFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when (e.cause) {
                is BaseException -> {
                    errorToJson((e.cause as BaseException).errorProperty, response)
                }

                is Exception -> {
                    errorToJson(InternalServerErrorException.errorProperty, response)
                }
            }
            Sentry.captureException(e)
        }
    }

    private fun errorToJson(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status()
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorProperty.of()))
    }
}
