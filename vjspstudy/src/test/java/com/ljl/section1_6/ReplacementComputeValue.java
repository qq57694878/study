package com.ljl.section1_6;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * meant to be used to override the existing computeValue(String)
 * implementation in MyValueCalculator
 */
@Service
public class ReplacementComputeValue implements MethodReplacer {
    public Object reimplement(Object o, Method m, Object[] args) throws Throwable {
        // get the input value, work with it, and return a computed result
        String input = (String) args[0];
        return input+"hahahahahahaha";
    }
}