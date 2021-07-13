package com.bidyut.springbootkafkademo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.bidyut.springbootkafkademo.dto.UserDTO;

@Configuration
public class Kafkaconfig {
	
	@Bean
	public ProducerFactory<String, UserDTO> getProducerFactory()
	{
		Map<String, Object> config= new HashMap<String, Object>();
		
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.106:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, UserDTO>(config);
		
	}
	
	@Bean
	public KafkaTemplate<String , UserDTO> getKafkaTemplet()
	{
		return new KafkaTemplate<>(getProducerFactory());
	}

}
