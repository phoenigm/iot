plugins {
    kotlin("jvm")
    id("org.springframework.boot")
    id("org.jetbrains.kotlin.plugin.noarg") version Vers.kotlin
}

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://repo.spring.io/milestone/")
    maven(url = "http://oss.jfrog.org/artifactory/oss-snapshot-local/")
}

dependencies {
    implementation(Libs.kotlinStdlib)
    implementation(Libs.kotlinReflect)
    implementation(Libs.kotlinJdk8)
    runtimeOnly(Libs.jaxb)

    implementation(Libs.jacksonKotlin)

    implementation(Libs.springWeb)
    implementation(Libs.springMqtt)
    implementation(Libs.springWebSocket)
    implementation("com.hivemq:hivemq-mqtt-client:1.2.1")

    testImplementation(Libs.springTest) {
        exclude("org.junit.vintage", "junit-vintage-engine")
    }
}
