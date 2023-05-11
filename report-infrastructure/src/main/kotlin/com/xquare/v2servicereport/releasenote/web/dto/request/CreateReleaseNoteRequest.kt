package com.xquare.v2servicereport.releasenote.web.dto.request

import javax.validation.constraints.NotBlank

data class CreateReleaseNoteRequest(
    @field:NotBlank
    val releaseVersion: String,
    @field:NotBlank
    val featureContent: String,
    @field:NotBlank
    val bugFixContent: String,
)
