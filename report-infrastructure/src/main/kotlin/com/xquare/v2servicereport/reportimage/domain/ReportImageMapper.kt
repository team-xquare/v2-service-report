package com.xquare.v2servicereport.reportimage.domain

import com.xquare.v2servicereport.report.domain.ReportRepository
import com.xquare.v2servicereport.report.exceptions.ReportNotFoundException
import com.xquare.v2servicereport.reportimage.ReportImage
import org.springframework.data.repository.findByIdOrNull

fun ReportImageEntity.toChangeEntityToDomain(): ReportImage {
    return ReportImage(
        id = this.id,
        imageUrl = this.imageUrl,
        reportId = this.reportEntity.id,
    )
}

fun ReportImage.toChangeDomainToEntity(reportRepository: ReportRepository): ReportImageEntity {
    val reportEntity = reportRepository.findByIdOrNull(this.reportId)
        ?: throw ReportNotFoundException

    return ReportImageEntity(
        id = this.id,
        imageUrl = this.imageUrl,
        reportEntity = reportEntity,
    )
}
