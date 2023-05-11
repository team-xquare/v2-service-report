package com.xquare.v2servicereport.releasenote.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ReleaseNoteRepository : CrudRepository<ReleaseNoteEntity, UUID>
