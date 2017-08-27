package com.ljl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/8/20/020.
 */
@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {
        System.out.println("anyPublicOperation ------");
    }

    @Pointcut("within(com.ljl..*)")
    private void inTrading() {
        System.out.println("inTrading ------");
    }

    @Pointcut("anyPublicOperation() && inTrading()")
    private void tradingOperation() {
        System.out.println("tradingOperation ------");
    }


 /*   //声明该方法是一个前置通知，在目标方法开始之前执行.第一个*表示任意修饰符  任意返回值，后边的*表示任意方法名
    //@Before("execution(* com.cgc.spring.aop.impl.AtithmeticCalculatorImpl.*(int, int) )")
    @Before("anyPublicOperation()")
    public void beforeMethod(JoinPoint joinPoint)
    {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("this is method "+methodName +" begin with "+ args);
    }

    //后置通知：在目标方法执行后(无论是否发生异常)，执行的通知
    //在后置通知中不能访问在目标方法中返回的执行结果
    @After("inTrading()")
    public void afterMethod(JoinPoint joinPoint)
    {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this is method "+methodName +" end with ");
    }

    //在方法正常结束后要执行的代码
    //返回通知是可以访问到方法的返回值的
    @AfterReturning(value="anyPublicOperation()",returning="result")
    public void afterReturning(JoinPoint joinPoint,Object result)
    {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this is method "+methodName +" after Returning " + result);
    }

    //在方法出现异常时，会执行的代码，而且可以访问到异常对象，且可以指定在出现  特定异常时在执行通知代码 Exception ex,NullPointerException ex
    @AfterThrowing(value="anyPublicOperation())",throwing="ex")
    public void afterThrowing(JoinPoint joinPoint , Exception ex)
    {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this is method "+methodName +" after Returning exception " + ex);
    }*/
}
