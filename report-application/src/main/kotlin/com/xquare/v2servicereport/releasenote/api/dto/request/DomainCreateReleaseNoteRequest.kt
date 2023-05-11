package com.xquare.v2servicereport.releasenote.api.dto.request

data class DomainCreateReleaseNoteRequest(
    val releaseVersion: String,
    val featureContent: String,
    val bugFixContent: String,
)
