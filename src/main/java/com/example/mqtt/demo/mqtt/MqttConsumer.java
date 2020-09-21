package com.example.mqtt.demo.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

/**
 * @program: mqtt
 * @description: mqtt消费者
 * @author: 71ang~
 * @create: 2020-09-04 17:25
 * @vsersion: V1.0
 */
@Component
@Slf4j
public class MqttConsumer {

    @Value("${mqtt.consumer.defaultTopic}")
    private String consumerDefaultTopic;
    /**
     * MQTT消息处理器（消费者）
     *
     * @return {@link org.springframework.messaging.MessageHandler}
     */
    @Bean
    @ServiceActivator(inputChannel = MqttConfig.INBOUND_CHANNEL)
    public MessageHandler handler() {
        return message -> {
            String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
            log.info("消费topic：{}消息：{}",topic,message);
        };
    }
}