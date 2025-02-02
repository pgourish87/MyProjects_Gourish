package com.javatechie.service;

import com.javatechie.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("Vihaan-topic", message);
        future.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("unable to send message=[" + message + "] due to: " + exception.getMessage());
            }
        });
    }

    public void sendEventsToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("javatechie-test", customer);
            future.whenComplete((result, exception) -> {
                if (exception == null) {
                    System.out.println("Sent message=[" + customer + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("unable to send message=[" + customer.toString() + "] due to: " + exception.getMessage());
                }
            });
        }
        catch (Exception ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
}
