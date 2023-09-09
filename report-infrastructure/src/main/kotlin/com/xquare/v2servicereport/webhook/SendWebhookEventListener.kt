package com.xquare.v2servicereport.webhook

import net.gpedro.integrations.slack.SlackApi
import net.gpedro.integrations.slack.SlackAttachment
import net.gpedro.integrations.slack.SlackMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class SendWebhookEventListener(
    @Value("\${webhook.url}")
    private val webhookUrl: String,
) {

    companion object {
        private const val REPORT_MESSAGE = "버그 제보 발생"
        private const val REPORT_REASON = "이유"
        private const val REPORT_CATEGORY = "카테고리"
        private const val REPORT_USER_NAME = "제보자"
        private const val MESSAGE_COLOR = "#e62e2e"
        private const val FALLBACK = "새로운 버그제보가 도착했습니다."
    }

    @Async
    @EventListener
    fun sendReportMessageToSlack(slackReport: SlackReport) {
        val slackAttachment = SlackAttachment().apply {
            createSlackAttachment(getReportReason(slackReport))
        }
        val slackMessage = SlackMessage("").apply {
            addAttachments(slackAttachment)
            createSlackImage(slackReport.imageUrls)
        }
        SlackApi(webhookUrl).call(slackMessage)
    }

    private fun getReportReason(slackReport: SlackReport) =
        "$REPORT_USER_NAME : ${slackReport.userName}\n$REPORT_REASON : ${slackReport.reason}\n$REPORT_CATEGORY : ${slackReport.category}"

    private fun SlackMessage.createSlackImage(imageUrls: List<String>) {
        imageUrls.map { imageUrl -> this.addAttachments(SlackAttachment().createSlackImageAttachment(imageUrl)) }
    }

    private fun SlackAttachment.createSlackAttachment(errorReason: String) = this.apply {
        setTitle(REPORT_MESSAGE)
        setText(errorReason)
        setFallback(FALLBACK)
        setColor(MESSAGE_COLOR)
    }

    private fun SlackAttachment.createSlackImageAttachment(imageUrl: String) = this.apply {
        setImageUrl(imageUrl)
        setFallback(FALLBACK)
        setColor(MESSAGE_COLOR)
    }
}
