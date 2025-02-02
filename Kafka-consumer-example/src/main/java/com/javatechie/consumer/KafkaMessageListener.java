package com.javatechie.consumer;

import com.javatechie.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "javatechie-test", groupId = "jt-group")
    public void consume(Customer customer) {
        log.info("Cunsumer consumed the events: {}", customer.toString());
    }

//    @KafkaListener(topics = "Vihaan-topic", groupId = "jt-group")
//    public void consume1(String message) {
//        log.info("Consumer1 consumed the message: {}", message);
//    }
//    @KafkaListener(topics = "Vihaan-topic", groupId = "jt-group")
//    public void consume2(String message) {
//        log.info("Consumer2 consumed the message: {}", message);
//    }
//    @KafkaListener(topics = "Vihaan-topic", groupId = "jt-group")
//    public void consume3(String message) {
//        log.info("Consumer3 consumed the message: {}", message);
//    }
//    @KafkaListener(topics = "Vihaan-topic", groupId = "jt-group")
//    public void consume4(String message) {
//        log.info("Consumer4 consumed the message: {}", message);
//    }
}
