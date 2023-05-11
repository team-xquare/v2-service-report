package com.xquare.v2servicereport.releasenote.api.impl

import com.xquare.v2servicereport.common.annotation.DomainService
import com.xquare.v2servicereport.releasenote.ReleaseNote
import com.xquare.v2servicereport.releasenote.api.ReleaseNoteApi
import com.xquare.v2servicereport.releasenote.api.dto.request.DomainCreateReleaseNoteRequest
import com.xquare.v2servicereport.releasenote.spi.CommandReleaseNoteSpi

@DomainService
class ReleaseNoteApiImpl(
    private val commandReleaseNoteSpi: CommandReleaseNoteSpi,
) : ReleaseNoteApi {

    override fun createReleaseNote(domainCreateReleaseNoteRequest: DomainCreateReleaseNoteRequest) {
        val (releaseVersion, featureContent, bugFixContent) = domainCreateReleaseNoteRequest

        commandReleaseNoteSpi.saveReleaseNote(
            ReleaseNote(
                releaseVersion = releaseVersion,
                featureContent = featureContent,
                bugFixContent = bugFixContent,
            ),
        )
    }
}
