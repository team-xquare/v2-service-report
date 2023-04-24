package com.xquare.v2servicereport.report.domain

import com.xquare.v2servicereport.common.annotation.Mapper
import com.xquare.v2servicereport.report.Report

@Mapper
class ReportMapper {

    fun domainToEntity(report: Report): ReportEntity {
        return ReportEntity(
            id = report.id,
            userId = report.userId,
            reason = report.reason,
            category = report.category,
            createdAt = report.createdAt,
        )
    }

    fun entityToDomain(reportEntity: ReportEntity): Report {
        return Report(
            id = reportEntity.id,
            userId = reportEntity.userId,
            reason = reportEntity.reason,
            category = reportEntity.category,
            createdAt = reportEntity.createdAt,
        )
    }
}
