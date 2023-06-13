package com.xquare.v2servicereport.webhook

data class SlackReport(
    val userName: String,
    val reason: String,
    val category: String,
    val imageUrls: List<String>,
)
