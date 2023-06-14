package com.xquare.v2servicereport.report.api.impl

import com.xquare.v2servicereport.common.annotation.DomainService
import com.xquare.v2servicereport.report.Report
import com.xquare.v2servicereport.report.api.ReportApi
import com.xquare.v2servicereport.report.api.dto.request.DomainCreateReportRequest
import com.xquare.v2servicereport.report.spi.CommandReportSpi
import com.xquare.v2servicereport.reportimage.ReportImage
import com.xquare.v2servicereport.reportimage.spi.CommandReportImageSpi
import com.xquare.v2servicereport.user.spi.UserSecuritySpi
import com.xquare.v2servicereport.user.spi.UserSpi
import com.xquare.v2servicereport.webhook.SlackReport
import com.xquare.v2servicereport.webhook.spi.SendWebhookSpi

@DomainService
class ReportApiImpl(
    private val userSpi: UserSpi,
    private val userSecuritySpi: UserSecuritySpi,
    private val commandReportSpi: CommandReportSpi,
    private val commandReportImageSpi: CommandReportImageSpi,
    private val sendWebhookSpi: SendWebhookSpi,
) : ReportApi {

    override fun createReport(domainCreateReportRequest: DomainCreateReportRequest) {
        val (reason, category, imageUrls) = domainCreateReportRequest
        val userId = userSecuritySpi.getCurrentUserId()

        val reportId = commandReportSpi.saveReportAndGetReportId(
            Report(
                userId = userId,
                reason = reason,
                category = category,
            ),
        )

        if (imageUrls.isNotEmpty()) {
            commandReportImageSpi.saveAllReportImage(
                imageUrls.map { imageUrl ->
                    ReportImage(
                        imageUrl = imageUrl,
                        reportId = reportId,
                    )
                },
            )
        }

        sendWebhookSpi.sendReportMessageToSlack(
            SlackReport(
                userName = userSpi.getUserByUserId(userId).name,
                reason = reason,
                category = category.name,
                imageUrls = imageUrls,
            ),
        )
    }
}
