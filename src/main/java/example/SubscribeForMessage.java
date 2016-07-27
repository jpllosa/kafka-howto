//   Copyright 2016 Joel Patrick Llosa
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
package example;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * 
 * @author Joel Patrick Llosa
 *
 */
public class SubscribeForMessage {

	// make sure Kafka is running
	// run SubscribeForMessage
	// check Kafka if topic is registered, kafka-topics.bat
	// run PublishMessage
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("group.id", "joel");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		consumer.subscribe(Arrays.asList("videos"));

		boolean keepPolling = true;
		while (keepPolling) {
			System.out.println("polling... Ctrl-C to exit");
			ConsumerRecords<String, String> messages = consumer.poll(5000L);

			for (ConsumerRecord<String, String> message : messages) {
				System.out.println("message: " + message.value());
				keepPolling = false;
			}
		}

		consumer.unsubscribe();
		consumer.close();
	}
}
