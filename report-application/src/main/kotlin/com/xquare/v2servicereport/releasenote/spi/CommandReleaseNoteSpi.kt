package com.xquare.v2servicereport.releasenote.spi

import com.xquare.v2servicereport.releasenote.ReleaseNote

interface CommandReleaseNoteSpi {
    fun saveReleaseNote(releaseNote: ReleaseNote)
}
