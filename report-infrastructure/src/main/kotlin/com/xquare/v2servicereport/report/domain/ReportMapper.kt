package com.xquare.v2servicereport.report.domain

import com.xquare.v2servicereport.report.Report

fun ReportEntity.toChangeEntityToDomain() = Report(
    id = this.id,
    userId = this.userId,
    reason = this.reason,
    category = this.category,
    createdAt = this.createdAt,
)

fun Report.toChangeDomainToEntity() = ReportEntity(
    id = this.id,
    userId = this.userId,
    reason = this.reason,
    category = this.category,
    createdAt = this.createdAt,
)
