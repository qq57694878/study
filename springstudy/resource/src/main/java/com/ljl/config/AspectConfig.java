package com.ljl.config;

import jdk.internal.instrumentation.TypeMapping;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.annotation.Target;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/20/020.
 */
@Component
@Aspect
public class AspectConfig {
    @Pointcut("execution(* com.ljl..po.*.set*(..))")
    private void poSet() {
    }

    @Pointcut("execution(* com.ljl..service.*.*(..))")
    private void service() {
    }

    @Pointcut("within(com.ljl.service.*)")
    private void serviceAll() {
    }

    @Pointcut("this(com.ljl.service.C)")
    private void c() {
    }

    ;

    @Pointcut("args(java.io.Serializable)")
    private void serializable() {
    }

    @Pointcut("target(java.io.Serializable)")
    private void serializableTarget() {
    }

    /*    @Target(value="org.springframework.transaction.annotation.Transactional")
        private void transactional(){}
        @Within(org.springframework.transaction.annotation.Transactional)
        private void transactional1(){}
        @annotation(org.springframework.transaction.annotation.Transactional)
        public void transactional2(){}*/
    @Pointcut("execution(* com.ljl.time..*.*(..))")
    private void aroundExecutionTimeJoinPoint() {
    }
    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    private void aroundExecutionTimeJoinPoint1() {
    }

    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    private void aroundTransactional(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("事务开始");
            joinPoint.proceed();
            System.out.println("事务结束");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    // @Around("execution(* com.ljl.time..*.*(..))")
    public void aroundExecutionTime(ProceedingJoinPoint joinPoint) {
        try {
            long s = System.currentTimeMillis();
            joinPoint.proceed();
            long e = System.currentTimeMillis();
            String methodName = joinPoint.getSignature().getName();
            System.out.println(methodName + "执行时间为:" + (e - s) + "毫秒");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Before("execution(* com.ljl.time.ExecutionTime.param(..)) && args(m,..)")
    public void beforeParam(Map<String, String> m) {
        System.out.println(m);
    }

    @Around("execution(* com.ljl.time..*.*(..))")
    public Object aroundExecutionTime1(ProceedingJoinPoint joinPoint) {
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        try {
            sw.start(joinPoint.getSignature().getName());
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
        return null;
    }

    @Around("execution(* com.ljl.time.ExecutionTime.getFoo(String,int))&& args(name,age)")
    public Object profile(ProceedingJoinPoint call, String name, int age) throws Throwable {
            StopWatch clock = new StopWatch("Profiling for '" + name + "' and '" + age + "'");
            try {
                clock.start(call.toShortString());
                return call.proceed();
            } finally {
                clock.stop();
                System.out.println(clock.prettyPrint());
            }
        }




}
