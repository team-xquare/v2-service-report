package com.xquare.v2servicereport.report.domain

import com.xquare.v2servicereport.report.Category
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_report")
@Entity
class ReportEntity(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "BINARY(16)")
    val userId: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    val reason: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    @Enumerated(EnumType.STRING)
    val category: Category,

    @Column(columnDefinition = "DATETIME")
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
