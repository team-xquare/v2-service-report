package com.xquare.v2servicereport.interceptor

import io.sentry.Sentry
import io.sentry.SentryEvent
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.util.UUID
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class RequestInterceptor : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val eventMessage = "${UUID.randomUUID()} - 버그 추가"
        val sentryEvent = SentryEvent()

        sentryEvent.message?.message = eventMessage

        Sentry.captureEvent(sentryEvent)

        return true
    }
}
