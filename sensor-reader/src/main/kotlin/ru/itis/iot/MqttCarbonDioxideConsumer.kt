package ru.itis.iot

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.simp.SimpMessageSendingOperations

@Configuration
open class MqttCarbonDioxideConsumer(
    private val socketTemplate: SimpMessageSendingOperations
) {

    @Value("\${websocket.endpoint}")
    private lateinit var endpoint: String

   /* @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    open fun handler(): MessageHandler {
        return MessageHandler { message ->
            println(message.payload)
            socketTemplate.convertAndSend(endpoint, message.payload)
        }
    }*/
}
