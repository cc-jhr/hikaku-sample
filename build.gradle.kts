import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.41")
    application
}

repositories {
    jcenter()
}

repositories {
    mavenCentral()
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.41")
    implementation("org.springframework.boot:spring-boot-starter-web:2.1.6.RELEASE")

    testImplementation("de.codecentric.hikaku:hikaku-openapi:2.3.0")
    testImplementation("de.codecentric.hikaku:hikaku-spring:2.3.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.1.6.RELEASE")
    testImplementation("org.junit.platform:junit-platform-launcher:1.5.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.41")
}

application {
    mainClassName = "de.codecentric.hikaku.sample.AppKt"
}

tasks.withType<Test> {
    useJUnitPlatform()
}