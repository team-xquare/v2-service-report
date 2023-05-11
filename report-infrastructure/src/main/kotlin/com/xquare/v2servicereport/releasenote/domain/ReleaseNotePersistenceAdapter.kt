package com.xquare.v2servicereport.releasenote.domain

import com.xquare.v2servicereport.common.annotation.Adapter
import com.xquare.v2servicereport.releasenote.ReleaseNote
import com.xquare.v2servicereport.releasenote.spi.ReleaseNoteSpi

@Adapter
class ReleaseNotePersistenceAdapter(
    private val releaseNoteRepository: ReleaseNoteRepository,
) : ReleaseNoteSpi {

    override fun saveReleaseNote(releaseNote: ReleaseNote) {
        releaseNoteRepository.save(releaseNote.toChangeDomainToEntity())
    }
}
