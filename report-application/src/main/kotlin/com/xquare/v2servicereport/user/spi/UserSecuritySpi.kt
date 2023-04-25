package com.xquare.v2servicereport.user.spi

import java.util.UUID

interface UserSecuritySpi {
    fun getCurrentUserId(): UUID
}
