package com.xquare.v2servicereport.common.config

import com.xquare.v2servicereport.BASE_PACKAGE
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(basePackages = [BASE_PACKAGE])
@Configuration
class PropertyConfig
