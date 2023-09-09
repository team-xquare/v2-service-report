package com.xquare.v2servicereport.webhook

import com.xquare.v2servicereport.webhook.spi.SendWebhookSpi
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class SendWebhookEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) : SendWebhookSpi {

    override fun sendReportMessageToSlack(slackReport: SlackReport) {
        applicationEventPublisher.publishEvent(slackReport)
    }
}
