package com.xquare.v2servicereport.report.domain

import com.xquare.v2servicereport.common.annotation.Adapter
import com.xquare.v2servicereport.report.Report
import com.xquare.v2servicereport.report.spi.ReportSpi
import java.util.UUID

@Adapter
class ReportPersistenceAdapter(
    private val reportMapper: ReportMapper,
    private val reportRepository: ReportRepository,
) : ReportSpi {

    override fun saveReportAndGetReportId(report: Report): UUID {
        val reportEntity = reportRepository.save(reportMapper.domainToEntity(report))
        return reportEntity.id
    }
}
