package com.carrie.lu.misc;

import com.carrie.lu.grpc.HelloResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Scope("singleton")
@Component
public class TrafficPool {

    public List<HelloResponse> trafficList = new LinkedList<>();

    public void put(HelloResponse helloResponse) {
        if(!trafficList.contains(helloResponse)) {
            trafficList.add(helloResponse);
        }
    }

    public List<HelloResponse> getAll() {
        return trafficList;
    }

    public List<HelloResponse> getById(HelloResponse helloResponse) {
        return null;
    }

}
