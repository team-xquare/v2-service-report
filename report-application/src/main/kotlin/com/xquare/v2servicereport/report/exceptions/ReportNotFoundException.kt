package com.xquare.v2servicereport.report.exceptions

import com.xquare.v2servicereport.common.error.BaseException
import com.xquare.v2servicereport.report.error.ReportErrorCoe

object ReportNotFoundException : BaseException(
    ReportErrorCoe.REPORT_NOT_FOUND,
)
