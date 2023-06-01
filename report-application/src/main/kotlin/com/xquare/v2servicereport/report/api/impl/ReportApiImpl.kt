package com.xquare.v2servicereport.report.api.impl

import com.xquare.v2servicereport.common.annotation.DomainService
import com.xquare.v2servicereport.report.Report
import com.xquare.v2servicereport.report.api.ReportApi
import com.xquare.v2servicereport.report.api.dto.request.DomainCreateReportRequest
import com.xquare.v2servicereport.report.spi.CommandReportSpi
import com.xquare.v2servicereport.reportimage.ReportImage
import com.xquare.v2servicereport.reportimage.spi.CommandReportImageSpi
import com.xquare.v2servicereport.user.spi.UserSecuritySpi
import com.xquare.v2servicereport.webhook.SlackReport
import com.xquare.v2servicereport.webhook.spi.SendWebhookSpi

@DomainService
class ReportApiImpl(
    private val userSecuritySpi: UserSecuritySpi,
    private val commandReportSpi: CommandReportSpi,
    private val commandReportImageSpi: CommandReportImageSpi,
    private val sendWebhookSpi: SendWebhookSpi,
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
            val reportImages = imageUrls.map { imageUrl ->
                ReportImage(
                    imageUrl = imageUrl,
                    reportId = reportId,
                )
            }
            commandReportImageSpi.saveAllReportImage(reportImages)
        }

        sendWebhookSpi.sendReportMessageToSlack(
            SlackReport(
                reason = reason,
                category = category.name,
                imageUrls = imageUrls,
            )
        )
    }
}
