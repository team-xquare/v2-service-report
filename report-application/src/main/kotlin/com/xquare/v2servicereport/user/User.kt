package com.xquare.v2servicereport.user

import java.time.LocalDate
import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
    val birthDay: LocalDate,
    val grade: Int,
    val classNum: Int,
    val profileFileName: String?,
    val password: String,
    val accountId: String,
    val num: Int,
)
