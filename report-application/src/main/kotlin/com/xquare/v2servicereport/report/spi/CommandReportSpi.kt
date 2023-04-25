package com.xquare.v2servicereport.report.spi

import com.xquare.v2servicereport.report.Report
import java.util.UUID

interface CommandReportSpi {

    fun saveReportAndGetReportId(report: Report): UUID
}
