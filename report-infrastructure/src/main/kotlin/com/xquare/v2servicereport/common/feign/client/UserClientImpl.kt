package com.xquare.v2servicereport.common.feign.client

import com.xquare.v2servicereport.user.spi.UserSpi
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserClientImpl : UserSpi {

    override fun getCurrentUserId(): UUID =
        UUID.fromString(SecurityContextHolder.getContext().authentication.name)
}
