package com.xquare.v2servicereport.common.feign.client

import com.xquare.v2servicereport.user.User
import com.xquare.v2servicereport.user.spi.UserSpi
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserClientImpl(
    private val userClient: UserClient,
) : UserSpi {

    override fun getCurrentUserId(): UUID =
        UUID.fromString(SecurityContextHolder.getContext().authentication.name)

    override fun getUserByUserId(userId: UUID): User {
        val user = userClient.getUserByUserId(userId)

        return User(
            id = user.id,
            accountId = user.accountId,
            password = user.password,
            name = user.name,
            grade = user.grade,
            classNum = user.classNum,
            num = user.num,
            birthDay = user.birthDay,
            profileFileName = user.profileFileName,
        )
    }
}
