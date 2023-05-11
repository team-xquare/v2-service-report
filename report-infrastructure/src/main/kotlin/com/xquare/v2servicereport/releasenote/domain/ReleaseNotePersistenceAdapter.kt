package com.xquare.v2servicereport.releasenote.domain

import com.linecorp.kotlinjdsl.QueryFactory
import com.linecorp.kotlinjdsl.listQuery
import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.xquare.v2servicereport.common.annotation.Adapter
import com.xquare.v2servicereport.releasenote.ReleaseNote
import com.xquare.v2servicereport.releasenote.spi.ReleaseNoteSpi

@Adapter
class ReleaseNotePersistenceAdapter(
    private val queryFactory: QueryFactory,
    private val releaseNoteRepository: ReleaseNoteRepository,
) : ReleaseNoteSpi {

    override fun saveReleaseNote(releaseNote: ReleaseNote) {
        releaseNoteRepository.save(releaseNote.toChangeDomainToEntity())
    }

    override fun queryReleaseNoteList(): List<ReleaseNote> =
        queryFactory.queryAllReleaseNote()
            .map(ReleaseNoteEntity::toChangeEntityToDomain)

    private fun QueryFactory.queryAllReleaseNote(): List<ReleaseNoteEntity> =
        this.listQuery {
            select(
                listOf(
                    col(ReleaseNoteEntity::id),
                    col(ReleaseNoteEntity::releaseVersion),
                    col(ReleaseNoteEntity::featureContent),
                    col(ReleaseNoteEntity::bugFixContent),
                )
            )
            from(entity(ReleaseNoteEntity::class))
            orderBy(col(ReleaseNoteEntity::releaseVersion).desc())
        }
}
