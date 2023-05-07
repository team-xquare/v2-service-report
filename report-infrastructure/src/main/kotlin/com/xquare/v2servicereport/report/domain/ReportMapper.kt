package com.xquare.v2servicereport.report.domain

import com.xquare.v2servicereport.report.Report

fun ReportEntity.toChangeEntityToDomain(): Report {
    return Report(
        id = this.id,
        userId = this.userId,
        reason = this.reason,
        category = this.category,
        createdAt = this.createdAt
    )
}

fun Report.toChangeDomainToEntity(): ReportEntity {
    return ReportEntity(
        id = this.id,
        userId = this.userId,
        reason = this.reason,
        category = this.category,
        createdAt = this.createdAt
    )
}
