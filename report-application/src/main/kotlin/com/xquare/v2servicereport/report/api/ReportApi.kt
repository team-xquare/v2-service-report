package com.xquare.v2servicereport.report.api

import com.xquare.v2servicereport.report.api.dto.request.DomainCreateReportRequest

interface ReportApi {
    fun createReport(domainCreateReportRequest: DomainCreateReportRequest)
}
