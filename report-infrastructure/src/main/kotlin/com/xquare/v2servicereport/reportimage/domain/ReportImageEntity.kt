package com.xquare.v2servicereport.reportimage.domain

import com.xquare.v2servicereport.report.domain.ReportEntity
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_report_image")
@Entity
class ReportImageEntity(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    val imageUrl: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "BINARY(16)", name = "report_id", nullable = false)
    val reportEntity: ReportEntity,
)
