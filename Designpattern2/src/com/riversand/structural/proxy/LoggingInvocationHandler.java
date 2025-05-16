package com.riversand.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[LOG] Invoking: " + method.getName());
        if (args != null) {
            for (Object arg : args) {
                System.out.println("    Arg: " + arg);
            }
        }
        Object result = method.invoke(target, args);
        System.out.println("[LOG] Result: " + result);
        return result;
    }
}
