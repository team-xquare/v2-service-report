package com.xquare.v2servicereport.reportimage.domain

import com.xquare.v2servicereport.common.annotation.Adapter
import com.xquare.v2servicereport.reportimage.ReportImage
import com.xquare.v2servicereport.reportimage.spi.ReportImageSpi

@Adapter
class ReportImagePersistenceAdapter(
    private val reportImageRepository: ReportImageRepository,
    private val reportImageMapper: ReportImageMapper,
) : ReportImageSpi {

    override fun saveReportImage(reportImage: ReportImage) {
        reportImageRepository.save(reportImageMapper.domainToEntity(reportImage))
    }
}
