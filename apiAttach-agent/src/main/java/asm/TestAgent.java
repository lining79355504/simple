package asm;

import java.lang.instrument.Instrumentation;

/**
 * Author:  lining17
 * Date :  2020-06-12
 */
public class TestAgent {

    public static void agentmain(String args, Instrumentation inst) {
        inst.addTransformer(new TestTransformer(), true);
        try {
            inst.retransformClasses(TransformTarget.class);
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
