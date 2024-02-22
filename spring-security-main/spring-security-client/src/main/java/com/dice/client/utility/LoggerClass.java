package com.dice.client.utility;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class LoggerClass {

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static Logger getLogger(String classname) {
        return (Logger) LoggerFactory.getLogger(classname);
    }
}
