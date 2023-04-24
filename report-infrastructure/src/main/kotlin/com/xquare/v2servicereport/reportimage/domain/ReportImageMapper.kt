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

    fun domainToEntity(reportImage: ReportImage): ReportImageEntity {
        val reportEntity = reportRepository.findByIdOrNull(reportImage.reportId)
            ?: throw ReportNotFoundException

        return ReportImageEntity(
            id = reportImage.id,
            imageUrl = reportImage.imageUrl,
            reportEntity = reportEntity,
        )
    }

    fun entityToDomain(reportImageEntity: ReportImageEntity): ReportImage {
        return ReportImage(
            id = reportImageEntity.id,
            imageUrl = reportImageEntity.imageUrl,
            reportId = reportImageEntity.reportEntity.id,
        )
    }
}
