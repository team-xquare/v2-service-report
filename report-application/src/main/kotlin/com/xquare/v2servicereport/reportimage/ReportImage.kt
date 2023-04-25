package com.xquare.v2servicereport.reportimage

import com.xquare.v2servicereport.common.annotation.Aggregate
import java.util.UUID

@Aggregate
data class ReportImage(
    val id: UUID = UUID.randomUUID(),
    val imageUrl: String,
    val reportId: UUID,
)
