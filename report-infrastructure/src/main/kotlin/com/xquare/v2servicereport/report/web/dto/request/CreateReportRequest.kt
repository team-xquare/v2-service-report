package com.xquare.v2servicereport.report.web.dto.request

import com.xquare.v2servicereport.report.Category
import javax.validation.constraints.NotBlank

data class CreateReportRequest(
    @field:NotBlank
    val reason: String,
    @field:NotBlank
    val category: Category,
    @field:NotBlank
    val imageUrls: List<String>,
)
