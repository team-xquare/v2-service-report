package com.xquare.v2servicereport.reportimage.domain

import com.xquare.v2servicereport.common.annotation.Mapper
import com.xquare.v2servicereport.report.domain.ReportRepository
import com.xquare.v2servicereport.report.exceptions.ReportNotFoundException
import com.xquare.v2servicereport.reportimage.ReportImage
import org.springframework.data.repository.findByIdOrNull

@Mapper
class ReportImageMapper(
    private val reportRepository: ReportRepository,
) {

    fun domainToEntity(reportImage: ReportImage): ReportImageEntity =
        reportImage.changeDomainToEntity()

    fun entityToDomain(reportImageEntity: ReportImageEntity): ReportImage =
        reportImageEntity.changeEntityToDomain()

    private fun ReportImageEntity.changeEntityToDomain(): ReportImage {
        return ReportImage(
            id = this.id,
            imageUrl = this.imageUrl,
            reportId = this.reportEntity.id,
        )
    }

    private fun ReportImage.changeDomainToEntity(): ReportImageEntity {
        val reportEntity = reportRepository.findByIdOrNull(this.reportId)
            ?: throw ReportNotFoundException

        return ReportImageEntity(
            id = this.id,
            imageUrl = this.imageUrl,
            reportEntity = reportEntity,
        )
    }
}
