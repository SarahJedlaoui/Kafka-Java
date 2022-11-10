//NOTE: Since you’re sending data to be processed, the produce() method really ought to be a POST. For demo purposes it’s easier to leave it as a GET so you can exercise it in the browser.
//As you can see, this endpoint is very simple. It injects the KafkaTemplate configured earlier and sends a message to myTopic when a GET request is made to /kafka/produce.


package com.okta.javakafka.controller;
import com.okta.javakafka.consumer.MyTopicConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> template;
    private MyTopicConsumer myTopicConsumer;

    public KafkaController(KafkaTemplate<String, String> template, MyTopicConsumer myTopicConsumer) {
        this.template = template;
        this.myTopicConsumer = myTopicConsumer;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("NewTopic", message);
    }
    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return myTopicConsumer.getMessages();
    }
}


// This class now has a new endpoint to display the messages stored in your consumer. When this endpoint is called, it sends the current messages it already processed from the Kafka topic.

