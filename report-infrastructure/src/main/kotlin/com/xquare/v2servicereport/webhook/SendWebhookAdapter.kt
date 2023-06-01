package com.xquare.v2servicereport.webhook

import com.xquare.v2servicereport.webhook.spi.SendWebhookSpi
import net.gpedro.integrations.slack.SlackApi
import net.gpedro.integrations.slack.SlackAttachment
import net.gpedro.integrations.slack.SlackMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SendWebhookAdapter(
    @Value("\${webhook.url}")
    private val webhookUrl: String,
) : SendWebhookSpi {

    companion object {
        const val REPORT_MESSAGE = "버그 제보 발생"
        const val REPORT_REASON = "이유"
        const val REPORT_CATEGORY = "카테고리"
        const val MESSAGE_COLOR = "#e62e2e"
        const val FALLBACK = "Required plain-text summary of the attachment"
    }

    override fun sendReportMessageToSlack(slackReport: SlackReport) {
        val slackMessage = SlackMessage("")
        val slackAttachment = SlackAttachment()
        val errorReason = createReportReason(slackReport.reason, slackReport.category)

        slackAttachment.createSlackAttachment(errorReason)
        slackMessage.addAttachments(slackAttachment)
        slackMessage.createSlackImage(slackReport.imageUrls)

        SlackApi(webhookUrl).call(slackMessage)
    }

    private fun createReportReason(reason: String, category: String) =
        "$REPORT_REASON : $reason\n$REPORT_CATEGORY : $category"

    private fun SlackAttachment.createSlackAttachment(errorReason: String) {
        this.setTitle(REPORT_MESSAGE)
        this.setText(errorReason)
        this.setColor(MESSAGE_COLOR)
        this.setFallback(FALLBACK)
    }

    private fun SlackMessage.createSlackImage(imageUrls: List<String>) {
        imageUrls.map { imageUrl ->
            this.addAttachments(
                SlackAttachment()
                    .setImageUrl(imageUrl)
                    .setFallback(FALLBACK)
            )
        }
    }
}
