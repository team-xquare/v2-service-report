package com.xquare.v2servicereport.releasenote.api.impl

import com.xquare.v2servicereport.common.annotation.DomainService
import com.xquare.v2servicereport.releasenote.ReleaseNote
import com.xquare.v2servicereport.releasenote.api.ReleaseNoteApi
import com.xquare.v2servicereport.releasenote.api.dto.request.DomainCreateReleaseNoteRequest
import com.xquare.v2servicereport.releasenote.api.dto.request.QueryReleaseNoteList
import com.xquare.v2servicereport.releasenote.api.dto.request.QueryReleaseNoteList.ReleaseNoteElement
import com.xquare.v2servicereport.releasenote.spi.CommandReleaseNoteSpi
import com.xquare.v2servicereport.releasenote.spi.QueryReleaseNoteSpi

@DomainService
class ReleaseNoteApiImpl(
    private val commandReleaseNoteSpi: CommandReleaseNoteSpi,
    private val queryReleaseNoteSpi: QueryReleaseNoteSpi,
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

    override fun getReleaseNoteList(): QueryReleaseNoteList {
        val releaseNoteList = queryReleaseNoteSpi.queryReleaseNoteList()

        val response = releaseNoteList.map { releaseNote ->
            ReleaseNoteElement(
                releaseNoteId = releaseNote.id,
                releaseVersion = releaseNote.releaseVersion,
                featureContent = releaseNote.featureContent,
                bugFixContent = releaseNote.bugFixContent,
            )
        }

        return QueryReleaseNoteList(response)
    }
}
