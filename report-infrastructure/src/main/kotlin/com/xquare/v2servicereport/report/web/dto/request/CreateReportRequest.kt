package com.xquare.v2servicereport.report.web.dto.request

import com.xquare.v2servicereport.report.Category

data class CreateReportRequest(
    val reason: String,
    val category: Category,
    val imageUrls: List<String>,
)
