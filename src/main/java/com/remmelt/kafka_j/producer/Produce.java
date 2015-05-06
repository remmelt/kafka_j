package com.remmelt.kafka_j.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Properties;

@Slf4j
public class Produce {
	public static void main(String[] args) {
		Properties props = new Properties();

		props.put("bootstrap.servers", "192.168.59.103:9092");
		props.put("key.serializer", org.apache.kafka.common.serialization.StringSerializer.class);
		props.put("value.serializer", org.apache.kafka.common.serialization.StringSerializer.class);

		Producer<String, String> producer = new KafkaProducer<>(props);

		producer.metrics().forEach((k, v) -> log.debug(k.toString(), v));

		for (int i = 0; i < 10; i++) {
			producer.send(new ProducerRecord<>("topic", String.format("[%s] SUPS (%d)", new Date(), i)));
		}

		producer.close();
	}
}
