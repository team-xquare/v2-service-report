package com.xquare.v2servicereport.releasenote.domain

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_release_note")
@Entity
class ReleaseNoteEntity(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    val releaseVersion: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    val featureContent: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    val bugFixContent: String,
)
