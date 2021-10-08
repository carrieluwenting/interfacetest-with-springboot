package com.carrie.lu.aop;

import com.carrie.lu.grpc.HelloResponse;
import com.carrie.lu.misc.TrafficPool;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static com.carrie.lu.util.ComponentFactory.$;

@Aspect
@Component
public class HelloAspect {

    @Around("@annotation(com.carrie.lu.annotation.AfterCheck)")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object object;
        try {
            System.out.println("Before executing the cut point");
            object = joinPoint.proceed();
            if(object instanceof HelloResponse) {
                handleHelloResponse((HelloResponse) object);
            }

            return object;
        } catch (Throwable throwable) {
            //to do error handling
        }
        return null;
    }

    private void handleHelloResponse(HelloResponse helloResponse) {
        System.out.println("Handling Hello Response.");
        $(TrafficPool.class).put(helloResponse);
    }
}
