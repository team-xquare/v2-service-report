package com.xquare.v2servicereport.releasenote.api

import com.xquare.v2servicereport.releasenote.api.dto.request.DomainCreateReleaseNoteRequest

interface ReleaseNoteApi {
    fun createReleaseNote(domainCreateReleaseNoteRequest: DomainCreateReleaseNoteRequest)
}
