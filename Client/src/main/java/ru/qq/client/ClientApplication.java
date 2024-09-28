package ru.qq.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.qq.grpc.MainServiceGrpc;
import ru.qq.grpc.numResponse;
import ru.qq.grpc.numsRequest;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);

        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext().build();

        MainServiceGrpc.MainServiceBlockingStub stub = MainServiceGrpc
                .newBlockingStub(channel);

        numsRequest request = numsRequest.newBuilder()
                .setNum1(10)
                .setNum2(23)
                .build();

        numResponse response = stub.getTestMessage(request);

        System.out.println(response.getNum());

        channel.shutdownNow();
    }

}
