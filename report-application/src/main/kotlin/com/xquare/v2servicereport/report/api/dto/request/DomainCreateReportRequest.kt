package com.xquare.v2servicereport.report.api.dto.request

import com.xquare.v2servicereport.report.Category

data class DomainCreateReportRequest(
    val reason: String,
    val category: Category,
    val imageUrls: List<String>,
)
