package ru.itis.iot

import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory
import org.springframework.integration.mqtt.core.MqttPahoClientFactory
import org.springframework.messaging.MessageChannel

@Configuration
open class MqttConfiguration {

    @Value("\${mqtt.url}")
    private lateinit var url: String

    @Value("\${mqtt.username}")
    private lateinit var username: String

    @Value("\${mqtt.password}")
    private lateinit var password: String

    @Bean
    open fun mqttClientFactory(): MqttPahoClientFactory {
        val factory = DefaultMqttPahoClientFactory()
        val options = MqttConnectOptions()
        options.serverURIs = arrayOf(url)
        options.userName = username
        options.password = password.toCharArray()
        factory.connectionOptions = options
        return factory
    }

    @Bean
    open fun mqttInputChannel(): MessageChannel = DirectChannel()

}