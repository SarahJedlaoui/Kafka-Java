//listening to the messages sent to the topic.

//This class is responsible for listening to changes inside the myTopic topic. It does so by using the KafkaListener annotation. Every time a new message is sent from a producer to the topic, your app receives a message inside this class. It adds a message to the list of messages received, making it available to other classes through the getMessages() method.
//




package com.okta.javakafka.consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyTopicConsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(String message) {
        synchronized (messages) {
            messages.add(message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }

}
