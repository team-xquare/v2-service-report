package com.xquare.v2servicereport.releasenote

import com.xquare.v2servicereport.common.annotation.Aggregate
import java.util.UUID

@Aggregate
data class ReleaseNote(
    val id: UUID = UUID.randomUUID(),
    val releaseVersion: String,
    val featureContent: String,
    val bugFixContent: String,
)
