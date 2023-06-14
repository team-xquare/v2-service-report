package com.xquare.v2servicereport.webhook

import net.gpedro.integrations.slack.SlackApi
import net.gpedro.integrations.slack.SlackAttachment
import net.gpedro.integrations.slack.SlackMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class SendWebhookEventHandler(
    @Value("\${webhook.url}")
    private val webhookUrl: String,
) {

    companion object {
        private const val REPORT_MESSAGE = "버그 제보 발생"
        private const val REPORT_REASON = "이유"
        private const val REPORT_CATEGORY = "카테고리"
        private const val REPORT_USER_NAME = "제보자"
        private const val MESSAGE_COLOR = "#e62e2e"
        private const val FALLBACK = "Required plain-text summary of the attachment"
    }

    @Async
    @EventListener
    fun sendReportMessageToSlack(slackReport: SlackReport) {
        val errorReason = createReportReason(slackReport.reason, slackReport.category, slackReport.userName)
        val slackAttachment = SlackAttachment().apply { createSlackAttachment(errorReason) }
        val slackMessage = SlackMessage("").apply {
            addAttachments(slackAttachment)
            createSlackImage(slackReport.imageUrls)
        }
        SlackApi(webhookUrl).call(slackMessage)
    }

    private fun createReportReason(reason: String, category: String, userName: String) =
        "$REPORT_USER_NAME : $userName\n$REPORT_REASON : $reason\n$REPORT_CATEGORY : $category"

    private fun SlackAttachment.createSlackAttachment(errorReason: String) {
        this.apply {
            setTitle(REPORT_MESSAGE)
            setText(errorReason)
            setColor(MESSAGE_COLOR)
            setFallback(FALLBACK)
        }
    }

    private fun SlackMessage.createSlackImage(imageUrls: List<String>) {
        imageUrls.map { imageUrl ->
            this.addAttachments(
                SlackAttachment().apply {
                    setImageUrl(imageUrl)
                    setFallback(FALLBACK)
                },
            )
        }
    }
}
