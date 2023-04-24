package com.xquare.v2servicereport.report.api.impl

import com.xquare.v2servicereport.common.annotation.DomainService
import com.xquare.v2servicereport.report.Report
import com.xquare.v2servicereport.report.api.ReportApi
import com.xquare.v2servicereport.report.api.dto.request.DomainCreateReportRequest
import com.xquare.v2servicereport.report.spi.CommandReportSpi
import com.xquare.v2servicereport.reportimage.ReportImage
import com.xquare.v2servicereport.reportimage.spi.CommandReportImageSpi
import com.xquare.v2servicereport.user.spi.UserSecuritySpi

@DomainService
class ReportApiImpl(
    private val userSecuritySpi: UserSecuritySpi,
    private val commandReportSpi: CommandReportSpi,
    private val commandReportImageSpi: CommandReportImageSpi,
) : ReportApi {

    override fun createReport(domainCreateReportRequest: DomainCreateReportRequest) {
        val (reason, category, imageUrls) = domainCreateReportRequest

        val report = Report(
            userId = userSecuritySpi.getCurrentUserId(),
            reason = reason,
            category = category,
        )

        val reportId = commandReportSpi.saveReportAndGetReportId(report)

        if (imageUrls.isNotEmpty()) {
            imageUrls.map { imageUrl ->
                val reportImage = ReportImage(
                    imageUrl = imageUrl,
                    reportId = reportId,
                )
                commandReportImageSpi.saveReportImage(reportImage)
            }
        }
    }
}
