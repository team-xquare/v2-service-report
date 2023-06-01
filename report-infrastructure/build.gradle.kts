plugins {
    id("org.springframework.boot") version "2.7.6"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.5")
    }
}

dependencies {
    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // MySQL
    runtimeOnly("mysql:mysql-connector-java")

    // Cloud Config
    implementation("org.springframework.cloud:spring-cloud-starter-config")

    // Open Feign
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Configuration Processor
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    // Kotlin JDSL
    implementation("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-starter:2.0.5.RELEASE")

    // Sentry
    implementation("io.sentry:sentry-spring-boot-starter:6.18.1")
    implementation("io.sentry:sentry-logback:6.18.1")

    // Webhook
    implementation("net.gpedro.integrations.slack:slack-webhook:1.4.0")

    implementation(project(":report-application"))
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

allOpen {
    annotation("javax.persistence.Entity")
}

noArg {
    annotation("javax.persistence.Entity")
}
