package com.xquare.v2servicereport.reportimage.domain

import com.xquare.v2servicereport.common.annotation.Adapter
import com.xquare.v2servicereport.report.domain.ReportRepository
import com.xquare.v2servicereport.reportimage.ReportImage
import com.xquare.v2servicereport.reportimage.spi.ReportImageSpi

@Adapter
class ReportImagePersistenceAdapter(
    private val reportRepository: ReportRepository,
    private val reportImageRepository: ReportImageRepository,
) : ReportImageSpi {

    override fun saveReportImage(reportImage: ReportImage) {
        reportImageRepository.save(reportImage.toChangeDomainToEntity(reportRepository))
    }

    override fun saveAllReportImage(reportImages: List<ReportImage>) {
        reportImageRepository.saveAll(reportImages.map { it.toChangeDomainToEntity(reportRepository) })
    }
}
