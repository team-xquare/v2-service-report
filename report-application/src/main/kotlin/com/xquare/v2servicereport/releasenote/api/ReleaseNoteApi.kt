package com.xquare.v2servicereport.releasenote.api

import com.xquare.v2servicereport.releasenote.api.dto.request.DomainCreateReleaseNoteRequest
import com.xquare.v2servicereport.releasenote.api.dto.request.QueryReleaseNoteList

interface ReleaseNoteApi {
    fun createReleaseNote(domainCreateReleaseNoteRequest: DomainCreateReleaseNoteRequest)
    fun getReleaseNoteList(): QueryReleaseNoteList
}
