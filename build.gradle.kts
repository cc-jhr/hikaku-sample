import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
    application
}

repositories {
    jcenter()
}

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web:2.1.3.RELEASE")

    testImplementation("de.codecentric.hikaku:hikaku-openapi:1.1.0-SNAPSHOT")
    testImplementation("de.codecentric.hikaku:hikaku-spring:1.1.0-SNAPSHOT")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.1.3.RELEASE")
    testImplementation("org.junit.platform:junit-platform-launcher:1.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.4.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.21")
}

application {
    mainClassName = "de.codecentric.hikaku.sample.AppKt"
}

tasks.withType<Test> {
    useJUnitPlatform()
}