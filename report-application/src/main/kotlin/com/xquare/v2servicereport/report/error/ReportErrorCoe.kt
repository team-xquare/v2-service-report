package com.xquare.v2servicereport.report.error

import com.xquare.v2servicereport.common.error.ErrorProperty

enum class ReportErrorCoe(
    private val status: Int,
    private val message: String,
) : ErrorProperty {

    REPORT_NOT_FOUND(404, "Report Not Found");

    override fun status(): Int = status
    override fun message(): String = message
}
