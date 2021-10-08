package com.carrie.lu;

import com.carrie.lu.grpc.HelloRequest;
import com.carrie.lu.grpc.HelloResponse;
import com.carrie.lu.grpc.HelloServiceGrpc;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@GRpcService
@Service
@Scope("prototype")
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Value("${grpc.port}")
    private int port;

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerBuilder
                .forPort(port)
                .addService(new HelloServiceImpl())
                .build()
                .start();
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String message = "Hello " + request.getFirstName()
                + " " + request.getLastName() + "!!!";
        HelloResponse helloResponse = HelloResponse.newBuilder().setMessage(message).build();

        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}
