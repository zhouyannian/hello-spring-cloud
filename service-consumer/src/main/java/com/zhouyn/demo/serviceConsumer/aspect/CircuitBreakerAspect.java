package com.zhouyn.demo.serviceConsumer.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
@Slf4j
public class CircuitBreakerAspect {

    private static final Integer THRESHOLD = 3;
    private Map<String, AtomicInteger> counter = new ConcurrentHashMap<>();
    private Map<String, AtomicInteger> breakCounter = new ConcurrentHashMap<>();

    @Around("execution(* com.zhouyn.demo.serviceConsumer.service..*(..))")
    public Object doWithCircuitBreaker(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String signature = proceedingJoinPoint.getSignature().toLongString();
        log.info("Invoke {}", signature);
        Object retVal;
        try {
            if (counter.containsKey(signature)) {
                if (counter.get(signature).get() > THRESHOLD && breakCounter.get(signature).get() < THRESHOLD) {
                    log.warn("Circuit breaker return null, break {} times.", breakCounter.get(signature).incrementAndGet());
                    return null;

                }
            } else {
                counter.put(signature, new AtomicInteger(0));
                breakCounter.put(signature, new AtomicInteger(0));
            }
            retVal = proceedingJoinPoint.proceed();
            counter.get(signature).set(0);
            breakCounter.get(signature).set(0);

        } catch (Throwable t) {
            log.warn("Cicuit breaker counter: {}, Throwable {}", counter.get(signature).incrementAndGet(), t.getMessage());
            breakCounter.get(signature).set(0);
            throw t;
        }
        return retVal;
    }
}
