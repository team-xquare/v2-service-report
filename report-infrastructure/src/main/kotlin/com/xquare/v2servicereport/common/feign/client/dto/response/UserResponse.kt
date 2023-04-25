package com.xquare.v2servicereport.common.feign.client.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDate
import java.util.UUID

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserResponse(
    val id: UUID,
    val name: String,
    val birthDay: LocalDate,
    val grade: Int,
    val classNum: Int,
    val profileFileName: String?,
    val password: String,
    val accountId: String,
    val num: Int
)
