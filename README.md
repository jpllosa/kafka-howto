# Kafka: How to send and receive messages
How to use Kafka 2.11 in Windows 7 for sending and receiving messages by Joel Patrick Llosa.

*Note:* use **Java 64-bit version**, the 32-bit version might give you an OutOfMemory error
during Map rebalancing.

### Publish/Subscribe Messaging Style (Topic)
1. Make sure Kafka is running
2. Run SubscribeForMessage
3. Check Kafka if the topic is registered, `kafka-topics.bat`
4. Run PublishMessage
