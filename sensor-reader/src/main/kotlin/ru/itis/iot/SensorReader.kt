package ru.itis.iot

import org.eclipse.paho.client.mqttv3.IMqttClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.eclipse.paho.client.mqttv3.MqttClient




@SpringBootApplication
open class SensorReader

fun main(args: Array<String>) {
    runApplication<SensorReader>(*args)
}
