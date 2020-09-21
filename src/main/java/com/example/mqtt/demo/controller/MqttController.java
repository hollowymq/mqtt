package com.example.mqtt.demo.controller;

/**
 * @program: mqtt
 * @description:
 * @author: 71ang~
 * @create: 2020-09-03 18:43
 * @vsersion: V1.0
 */

import com.example.mqtt.demo.mqtt.IMqttSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * MQTT消息发送
 *
 * @author BBF
 */
@Controller
@RequestMapping(value = "/")
public class MqttController {

    /**
     * 注入发送MQTT的Bean
     */
    @Resource
    private IMqttSender iMqttSender;

    /**
     * 发送MQTT消息
     * @param message 消息内容
     * @return 返回
     */
    @ResponseBody
    @GetMapping(value = "/mqtt", produces ="text/html")
    public Object sendMqtt(@RequestParam(value = "msg") String message) {
        for (int i = 0; i< 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            iMqttSender.sendToMqtt(message);
        }
        return "success";
    }
}