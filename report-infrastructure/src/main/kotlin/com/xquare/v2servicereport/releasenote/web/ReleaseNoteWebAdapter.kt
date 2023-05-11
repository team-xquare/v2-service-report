package com.xquare.v2servicereport.releasenote.web

import com.xquare.v2servicereport.releasenote.api.ReleaseNoteApi
import com.xquare.v2servicereport.releasenote.api.dto.request.DomainCreateReleaseNoteRequest
import com.xquare.v2servicereport.releasenote.web.dto.request.CreateReleaseNoteRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/note")
@RestController
class ReleaseNoteWebAdapter(
    private val releaseNoteApi: ReleaseNoteApi,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createReleaseNote(
        @RequestBody
        @Valid
        request: CreateReleaseNoteRequest,
    ) {
        val domainCreateReleaseNoteRequest = DomainCreateReleaseNoteRequest(
            releaseVersion = request.releaseVersion,
            featureContent = request.featureContent,
            bugFixContent = request.bugFixContent,
        )
        releaseNoteApi.createReleaseNote(domainCreateReleaseNoteRequest)
    }
}
