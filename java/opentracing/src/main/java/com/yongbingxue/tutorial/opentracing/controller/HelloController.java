package com.yongbingxue.tutorial.opentracing.controller;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

public class HelloController {
    private final Tracer tracer;

    private HelloController(Tracer tracer) {
        this.tracer = tracer;
    }

    private void sayHello(String helloTo) {
        Span span = tracer.buildSpan("say-hello").start();

        String helloStr = String.format("HelloController, %s!", helloTo);
        System.out.println(helloStr);

        span.finish();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Expecting one argument");
        }
        String helloTo = args[0];
        new HelloController(GlobalTracer.get()).sayHello(helloTo);
    }
}
