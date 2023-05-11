package com.xquare.v2servicereport.releasenote.api.dto.request

import java.util.UUID

data class QueryReleaseNoteList(
    val releaseNoteList: List<ReleaseNoteElement>,
) {
    data class ReleaseNoteElement(
        val releaseNoteId: UUID,
        val releaseVersion: String,
        val featureContent: String,
        val bugFixContent: String,
    )
}
