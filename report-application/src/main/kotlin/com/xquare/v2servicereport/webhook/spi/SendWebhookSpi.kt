package com.xquare.v2servicereport.webhook.spi

import com.xquare.v2servicereport.webhook.SlackReport

interface SendWebhookSpi {
    fun sendReportMessageToSlack(slackReport: SlackReport)
}
