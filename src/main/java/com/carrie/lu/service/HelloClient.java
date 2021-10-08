package com.carrie.lu.service;

import com.carrie.lu.annotation.AfterCheck;
import com.carrie.lu.grpc.HelloRequest;
import com.carrie.lu.grpc.HelloResponse;
import com.carrie.lu.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope("prototype")
public class HelloClient {

    @Value("${grpc.server}")
    private String server;

    @Value("${grpc.port}")
    private int port;

    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress(server, port).usePlaintext().build();

        helloServiceBlockingStub =
                HelloServiceGrpc.newBlockingStub(managedChannel);
    }

    @AfterCheck
    public HelloResponse sayHello(String firstName, String lastName) {
        HelloRequest hello = HelloRequest.newBuilder().setFirstName(firstName)
                .setLastName(lastName).build();

        HelloResponse helloResponse =
                helloServiceBlockingStub.sayHello(hello);

        return helloResponse;
    }
}
