package ru.qq.service;

import io.grpc.stub.StreamObserver;
import ru.qq.grpc.MainServiceGrpc;
import ru.qq.grpc.numResponse;
import ru.qq.grpc.numsRequest;

public class MainServiceImpl extends MainServiceGrpc.MainServiceImplBase {
    @Override
    public void getTestMessage(numsRequest request, StreamObserver<numResponse> responseObserver) {
        System.out.println("something");
        numResponse response = numResponse
                .newBuilder()
                .setNum(request.getNum1() + request.getNum2())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();

    }
}
