package com.bidyut.springbootkafkademoconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.streams.HeaderEnricher.Container;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.bidyut.springbootkafkademoconsumer.dto.UserDTO;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	/*
	 * @Bean public ConsumerFactory<String, String> consumerFactory() { Map<String,
	 * Object> config = new HashMap<>();
	 * 
	 * config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	 * config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
	 * config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	 * StringDeserializer.class);
	 * config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	 * StringDeserializer.class);
	 * 
	 * return new DefaultKafkaConsumerFactory<>(config); }
	 */


	/*
	 * @Bean public ConcurrentKafkaListenerContainerFactory<String, String>
	 * kafkaListenerContainerFactory() {
	 * ConcurrentKafkaListenerContainerFactory<String, String> factory = new
	 * ConcurrentKafkaListenerContainerFactory();
	 * factory.setConsumerFactory(consumerFactory()); return factory; }
	 */

    @Bean
    public ConsumerFactory<String, UserDTO> userConsumerFactory() {
    	
    	JsonDeserializer<UserDTO> deserializer = new JsonDeserializer<>(UserDTO.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.106:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,  "test-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
        		deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserDTO> userKafkaListenerFactory() {
    	

        ConcurrentKafkaListenerContainerFactory<String, UserDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }

}
