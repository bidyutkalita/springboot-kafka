package com.bidyut.springbootkafkademoconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bidyut.springbootkafkademoconsumer.dto.UserDTO;

@Service
public class KafkaConsumer {

	/*
	 * @KafkaListener(topics = "testTopic", group = "group_id") public void
	 * consume(String message) { System.out.println("Consumed message: " + message);
	 * }
	 */


    @KafkaListener(topics = "testTopic", groupId = "test-group",  containerFactory = "userKafkaListenerFactory")
    public void consumeJson(UserDTO user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}
