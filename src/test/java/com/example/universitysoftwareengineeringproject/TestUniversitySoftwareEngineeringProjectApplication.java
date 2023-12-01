package com.example.universitysoftwareengineeringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestUniversitySoftwareEngineeringProjectApplication {

    @Bean
    @ServiceConnection(name = "symptoma/activemq")
    GenericContainer<?> activeMQContainer() {
        return new GenericContainer<>(DockerImageName.parse("symptoma/activemq:latest")).withExposedPorts(61616);
    }

    @Bean
    @ServiceConnection
    KafkaContainer kafkaContainer() {
        return new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
    }

    @Bean
    @ServiceConnection
    MySQLContainer<?> mysqlContainer() {
        return new MySQLContainer<>(DockerImageName.parse("mysql:latest"));
    }

    public static void main(String[] args) {
        SpringApplication.from(UniversitySoftwareEngineeringProjectApplication::main).with(TestUniversitySoftwareEngineeringProjectApplication.class).run(args);
    }

}
