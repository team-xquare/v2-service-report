package com.xquare.v2servicereport

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

internal const val BASE_PACKAGE = "com.xquare.v2servicereport"

@SpringBootApplication
class V2ServiceReportApplication

fun main(args: Array<String>) {
    runApplication<V2ServiceReportApplication>(*args)
}
