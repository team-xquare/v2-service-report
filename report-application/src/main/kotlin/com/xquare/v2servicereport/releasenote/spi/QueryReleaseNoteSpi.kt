package com.xquare.v2servicereport.releasenote.spi

import com.xquare.v2servicereport.releasenote.ReleaseNote

interface QueryReleaseNoteSpi {
    fun queryReleaseNoteList(): List<ReleaseNote>
}
