package com.riversand.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * LoggingInvocationHandler handled applies on every method of MyServiceImpl
 * For void method it will not return anything
 * For other methods it will return , and for all methods it prints arguments as well
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        MyService originalService = new MyServiceImpl();

        MyService proxyService = (MyService) Proxy.newProxyInstance(
                MyService.class.getClassLoader(),
                new Class[] { MyService.class },
                new LoggingInvocationHandler(originalService)
        );

        proxyService.doTask();
        String result = proxyService.getData("user123");
        System.out.println("Returned: " + result);
    }
}
