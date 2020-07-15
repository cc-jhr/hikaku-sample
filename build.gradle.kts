import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.72")
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
        kotlinOptions.jvmTarget = "11"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.72")
    implementation("org.springframework.boot:spring-boot-starter-web:2.1.6.RELEASE")

    testImplementation("de.codecentric.hikaku:hikaku-openapi:3.1.2")
    testImplementation("de.codecentric.hikaku:hikaku-spring:3.1.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.3.1.RELEASE")
    testImplementation("org.junit.platform:junit-platform-launcher:1.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.72")
}

application {
    mainClassName = "de.codecentric.hikaku.sample.AppKt"
}

tasks.withType<Test> {
    useJUnitPlatform()
}