package ru.qq.server;

import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.qq.service.MainServiceImpl;

import java.io.IOException;

//@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
//        SpringApplication.run(ServerApplication.class, args);
        ServerBuilder.forPort(8080).addService(new MainServiceImpl()).build().start().awaitTermination();
    }

}
