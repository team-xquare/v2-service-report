package com.xquare.v2servicereport.report

import com.xquare.v2servicereport.common.annotation.Aggregate
import java.time.LocalDateTime
import java.util.UUID

@Aggregate
data class Report(
    val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    val reason: String,
    val category: Category,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
