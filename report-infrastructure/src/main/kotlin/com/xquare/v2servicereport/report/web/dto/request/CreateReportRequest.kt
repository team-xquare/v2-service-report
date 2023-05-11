package com.xquare.v2servicereport.report.web.dto.request

import com.xquare.v2servicereport.report.Category
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateReportRequest(
    @field:NotBlank
    val reason: String,
    @field:NotNull
    val category: Category,
    @field:NotNull
    val imageUrls: List<String>,
)
