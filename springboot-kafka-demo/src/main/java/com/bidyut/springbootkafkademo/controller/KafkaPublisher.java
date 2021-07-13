package com.bidyut.springbootkafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bidyut.springbootkafkademo.dto.UserDTO;

@RestController
@RequestMapping("publish")
public class KafkaPublisher {
	
	@Autowired
	KafkaTemplate<String , UserDTO> kafkkaTemplet;
	
	@GetMapping("/{message}")
	@ResponseBody
	public String publishToKafka(@PathVariable("message") String message)
	{
		kafkkaTemplet.send("testTopic",new UserDTO("Bidyut", message) );
		return "published";
	}
	/*running zookeeper
	 * D:\Bidyut\kafka>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
	 * 
	 * running kafka server
	 * D:\Bidyut\kafka>bin\windows\kafka-server-start.bat config\server.properties
	 * 
	 * creating topic
	 * kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic testTopic
	 */

}
