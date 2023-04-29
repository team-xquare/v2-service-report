package com.xquare.v2servicereport.reportimage.spi

import com.xquare.v2servicereport.reportimage.ReportImage

interface CommandReportImageSpi {
    fun saveReportImage(reportImage: ReportImage)
    fun saveAllReportImage(reportImages: List<ReportImage>)
}
