package com.xquare.v2servicereport.report.web

import com.xquare.v2servicereport.report.api.ReportApi
import com.xquare.v2servicereport.report.api.dto.request.DomainCreateReportRequest
import com.xquare.v2servicereport.report.web.dto.request.CreateReportRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class ReportWebAdapter(
    private val reportApi: ReportApi,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/report")
    fun createReport(
        @RequestBody
        @Valid
        request: CreateReportRequest
    ) {
        val domainCreateReportRequest = DomainCreateReportRequest(
            reason = request.reason,
            category = request.category,
            imageUrls = request.imageUrls,
        )
        reportApi.createReport(domainCreateReportRequest)
    }
}
