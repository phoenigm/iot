object Vers {
    const val kotlin = "1.4.20"

    const val springBoot = "2.4.4"

    const val postgres = "42.2.18"

    const val reactorTest = "3.4.2"
    const val jacksonKotlin = "2.12.1"
    const val jaxb = "2.3.1"
    const val swagger = "3.0.0"
    const val mqtt = "1.2.1"

}

object Libs {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Vers.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Vers.kotlin}"
    const val kotlinJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Vers.kotlin}"

    const val mqtt = "com.hivemq:hivemq-mqtt-client::${Vers.mqtt}"

    const val springTest = "org.springframework.boot:spring-boot-starter-test:${Vers.springBoot}"

    const val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${Vers.jacksonKotlin}"

    const val reactorTest = "io.projectreactor:reactor-test:${Vers.reactorTest}"

    const val jaxb = "javax.xml.bind:jaxb-api:${Vers.jaxb}"

    const val springWeb = "org.springframework.boot:spring-boot-starter-web:${Vers.springBoot}"

}
