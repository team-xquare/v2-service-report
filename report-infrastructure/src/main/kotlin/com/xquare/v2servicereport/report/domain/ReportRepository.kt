package com.xquare.v2servicereport.report.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ReportRepository : CrudRepository<ReportEntity, UUID>
