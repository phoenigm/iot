package ru.itis.iot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SensorReader

fun main(args: Array<String>) {
    runApplication<SensorReader>(*args)
}
