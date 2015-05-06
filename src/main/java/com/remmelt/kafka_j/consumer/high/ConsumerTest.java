package com.remmelt.kafka_j.consumer.high;

import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

public class ConsumerTest implements Runnable {
	private KafkaStream<byte[], byte[]> m_stream;
	private int m_threadNumber;

	public ConsumerTest(KafkaStream<byte[], byte[]> a_stream, int a_threadNumber) {
		m_threadNumber = a_threadNumber;
		m_stream = a_stream;
	}

	public void run() {
		for (MessageAndMetadata<byte[], byte[]> aM_stream : m_stream) {
			System.out.println("Thread " + m_threadNumber + ": " + new String(aM_stream.message()));
		}
		System.out.println("Shutting down Thread: " + m_threadNumber);
	}
}
