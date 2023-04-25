package com.xquare.v2servicereport.reportimage.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ReportImageRepository : CrudRepository<ReportImageEntity, UUID>
