package com.mort.asm_btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;

import static com.sun.btrace.BTraceUtils.println;

/**
 * Author:  lining17
 * Date :  2020-04-01
 */

@BTrace(unsafe = true)
public class DumpField {

    /*

    RaptorMobileCustomMetricAlarmDataAggregator extends CustomMetricAggregate

    polyData 存在于 CustomMetricAggregate

     */

    @OnMethod(clazz = "+com.dianping.cat.broker.api.consumer.alarm.CustomMetricAggregate",
            method = "sendPolyData", location = @Location(value = Kind.RETURN))
    public static void traceClassField(@Self Object self, @Return AnyType result) {
        Field field = BTraceUtils.field("com.dianping.cat.broker.api.consumer.alarm.CustomMetricAggregate", "polyData");
//        println("data = " + JSON.toJSON(BTraceUtils.get(field, self)));
        println(self.getClass().getName() + "  data = " + BTraceUtils.get(field, self));

    }

    @OnMethod(clazz = "com.dianping.cat.broker.api.consumer.alarm.RaptorMobileCustomMetricAlarmDataAggregator",
            method = "ruleProcess", location = @Location(value = Kind.RETURN))
    public static void traceRule(@Self Object self, @Return AnyType result) {
        Field field = BTraceUtils.field("com.dianping.cat.broker.api.consumer.alarm.CustomMetricAggregate", "polyData");
//        println("data = " + JSON.toJSON(BTraceUtils.get(field, self)));
        println("ruleProcess = " + BTraceUtils.get(field, self));

    }

}
