package ru.itis.iot

import com.hivemq.client.mqtt.MqttClient
import com.hivemq.client.mqtt.mqtt3.Mqtt3AsyncClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque


@Configuration
open class MqttConfiguration {

    companion object {
        val log: Logger = LoggerFactory.getLogger(MqttConfiguration::class.java)
    }

    @Value("\${mqtt.host}")
    private lateinit var host: String

    @Value("\${mqtt.port}")
    private lateinit var port: String

    @Value("\${mqtt.username}")
    private lateinit var username: String

    @Value("\${mqtt.password}")
    private lateinit var password: String

    @Value("\${mqtt.clientId}")
    private lateinit var clientId: String

    @Value("\${mqtt.topic}")
    private lateinit var topic: String

    @Bean
    open fun cache(): Deque<String> = ConcurrentLinkedDeque()

    @Bean
    open fun mqtt(cache: Deque<String>): MqttClient {
        val client: Mqtt3AsyncClient = MqttClient.builder()
            .useMqttVersion3()
            .identifier(clientId)
            .sslWithDefaultConfig()
            .serverHost(host).serverPort(port.toInt())
            .simpleAuth()
            .username(username)
            .password(password.toByteArray())
            .applySimpleAuth()
            .buildAsync()

        client.connect().whenComplete { _, error ->
            if (error != null) {
                log.error("When connecting error occurred $error", error)
                return@whenComplete
            }
            log.info("Connected!")
            client.subscribeWith()
                .topicFilter(topic)
                .callback { message ->
                    val payload = String(message.payloadAsBytes)
                    cache.clear()
                    cache.add(payload)
                    log.info(payload)
                }
                .send()
                .whenComplete { _, subscribingError ->
                    if (subscribingError != null) {
                        log.info("When subscribing error occurred $subscribingError", subscribingError)
                    }
                    log.info("Subscribed!")
                }
        }
        return client
    }

}