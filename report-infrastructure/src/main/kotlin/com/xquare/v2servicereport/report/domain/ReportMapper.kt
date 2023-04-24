package com.xquare.v2servicereport.report.domain

import com.xquare.v2servicereport.common.annotation.Mapper
import com.xquare.v2servicereport.report.Report

@Mapper
class ReportMapper {

    fun domainToEntity(report: Report): ReportEntity =
        report.toChangeDomainToEntity()

    fun entityToDomain(reportEntity: ReportEntity): Report =
        reportEntity.toChangeEntityToDomain()

    private fun ReportEntity.toChangeEntityToDomain(): Report {
        return Report(
            id = this.id,
            userId = this.id,
            reason = this.reason,
            category = this.category,
            createdAt = this.createdAt
        )
    }

    private fun Report.toChangeDomainToEntity(): ReportEntity {
        return ReportEntity(
            id = this.id,
            userId = this.id,
            reason = this.reason,
            category = this.category,
            createdAt = this.createdAt
        )
    }
}
