plugins {
    kotlin("jvm") version "2.4.10"
}

group = "url.shortener"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.xerial:sqlite-jdbc:3.53.4.0")
}

kotlin {
    jvmToolchain(26)
}

tasks.test {
    useJUnitPlatform()
}