package com.xquare.v2servicereport.user.spi

import com.xquare.v2servicereport.user.User
import java.util.UUID

interface UserSpi : UserSecuritySpi {
    fun getUserByUserId(userId: UUID): User
}
