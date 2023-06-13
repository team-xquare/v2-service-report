package com.xquare.v2servicereport.user

import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
    val grade: Int,
    val classNum: Int,
    val num: Int,
    val profileFileName: String?,
)
