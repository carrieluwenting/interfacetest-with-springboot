package com.carrie.lu;

import com.carrie.lu.grpc.HelloResponse;
import com.carrie.lu.misc.TrafficPool;
import com.carrie.lu.service.HelloClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.carrie.lu.util.ComponentFactory.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DemoGRPCInterfaceTest extends DemoTest{

    @Autowired
    private HelloClient helloClient;

    @Test
    public void testSayHello() {
        helloClient.sayHello("John", "Doe");
        helloClient.sayHello("Jane", "Doe");
        helloClient.sayHello("He", "Doe");
        helloClient.sayHello("Her", "Doe");

        assertThat("Check Response", helloClient.sayHello("John", "Doe").getMessage(), equalTo("Hello John Doe!!!"));

        System.out.println("********To get response from memory************");
        List<HelloResponse> trafficList =  $(TrafficPool.class).getAll();
        for(HelloResponse response : trafficList) {
            System.out.println(response.getMessage());
        }
    }

}
