package com.xquare.v2servicereport.releasenote.domain

import com.xquare.v2servicereport.releasenote.ReleaseNote

fun ReleaseNoteEntity.toChangeEntityToDomain() = ReleaseNote(
    id = this.id,
    releaseVersion = this.releaseVersion,
    featureContent = this.featureContent,
    bugFixContent = this.bugFixContent,
)

fun ReleaseNote.toChangeDomainToEntity() = ReleaseNoteEntity(
    id = this.id,
    releaseVersion = this.releaseVersion,
    featureContent = this.featureContent,
    bugFixContent = this.bugFixContent,
)
