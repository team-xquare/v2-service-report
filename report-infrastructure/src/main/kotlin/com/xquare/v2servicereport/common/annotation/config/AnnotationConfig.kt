package com.xquare.v2servicereport.common.annotation.config

import com.xquare.v2servicereport.BASE_PACKAGE
import com.xquare.v2servicereport.common.annotation.DomainService
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = [BASE_PACKAGE],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = [DomainService::class]
        )
    ]
)
class AnnotationConfig
