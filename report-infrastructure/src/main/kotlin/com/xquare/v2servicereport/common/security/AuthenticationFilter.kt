package com.xquare.v2servicereport.common.security

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val userId: String? = request.getHeader("Request-User-Id")
        val userRole: UserRole? = request.getHeader("Request-User-Role")?.let { UserRole.valueOf(it) }
        val userAuthorities: List<String>? = request.getHeader("Request-User-Authorities")?.let { listOf(it) }

        if (userId == null || userRole == null || userAuthorities == null) {
            filterChain.doFilter(request, response)
            return
        }

        val userAuthorityGrants = userAuthorities.map { userAuthority -> SimpleGrantedAuthority(userAuthority) }
        val userRoleGrant = SimpleGrantedAuthority("ROLE_${userRole.name}")
        val authorities: Collection<SimpleGrantedAuthority> = userAuthorityGrants.plus(userRoleGrant)

        val userDetails = User(userId, "", authorities)
        val authentication = UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        SecurityContextHolder.getContext().authentication = authentication

        filterChain.doFilter(request, response)
    }
}
