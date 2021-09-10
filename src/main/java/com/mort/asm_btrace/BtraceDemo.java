package com.mort.asm_btrace;

import com.alibaba.fastjson.JSON;
import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;

import static com.sun.btrace.BTraceUtils.*;

/**
 * Author:  lining17
 * Date :  2019-09-18
 */

/*
*
*
* @BTrace(unsafe = true)，并使用-u选项btrace -u <PID> <trace_script>来启动跟踪。
*
* 例如使用JSON.toJSONString()来打印对象（使用-cp选项来指明外部依赖的jar路径）：
*
*  bin/btrace -u -cp .:/Users/mort/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/Users/mort/.m2/repository/com/alibaba/fastjson/1.2.47/fastjson-1.2.47.jar  32535 /Users/mort/simple/src/main/java/asm_btrace/BtraceDemo.java
*
*
* bin/btrace == sh 脚本即等于
*  java -cp /Users/mort/btrace/build/btrace-client.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131
* .jdk/Contents/Home/lib/tools.jar:/usr/share/lib/java/dtrace.jar com.sun.btrace.client.Main
*
*
 */

@BTrace(unsafe = true)
public class BtraceDemo {

    //监控某一个方法的执行时间
    @OnMethod(clazz = "com.dianping.cat.broker.api.consumer.alarm.RaptorMobileCustomMetricAlarmDataAggregator", method = "ruleProcess", location = @Location(Kind.RETURN))
    public static void printMethodRunTime(@ProbeClassName String probeClassName, @Duration long duration , AnyType[] args) {
        println(probeClassName + ",duration:" + duration / 1000000 + " ms");
//        print(JSON.toJSON(args));
        jstack();
//        jstackStr(10);
//        jstackAll();
        println(args.length);
        for (int i = 0; i < args.length; i++) {
            try {

                println(JSON.toJSONString(args[i]));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        printArray(args);
    }

//    //
//
//    //JDK的类这样写就行
//    private static Field fdFiled = field("java.io,FileInputStream", "fd");
//
//    //非JDK的类，要给出ClassLoader，否则ClassNotFound
//    private static Field portField = field(classForName("com.dianping.cat.broker.api.consumer.alarm.RaptorMobileCustomMetricAlarmDataAggregator", contextClassLoader()), "port");
//
//    public static void onChannelRead(@Self Object self) {
//        println("port:" + getInt(portField, self));
//    }

}
