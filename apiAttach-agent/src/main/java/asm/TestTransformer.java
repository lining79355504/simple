package asm;

import jdk.internal.org.objectweb.asm.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Map;

/**
 * Author:  lining17
 * Date :  2020-06-12
 */

/*
*
* // number 可以不用新增 一个label 一行不变
*
*
* */
public class TestTransformer implements ClassFileTransformer {

    ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal();

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Transforming " + className);
        ClassReader reader = new ClassReader(classfileBuffer);
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        ClassVisitor classVisitor = new TestClassVisitor(Opcodes.ASM5, classWriter);
        reader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        return classWriter.toByteArray();
    }

    class TestClassVisitor extends ClassVisitor implements Opcodes {
        TestClassVisitor(int api, ClassVisitor classVisitor) {
            super(api, classVisitor);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
            if (name.equals("printSomething")) {
                //byte code change

                mv.visitCode();
                Label l0 = new Label();
                mv.visitLabel(l0);
                mv.visitLineNumber(31, l0);
                mv.visitFieldInsn(Opcodes.GETSTATIC, "asm/TransformTarget", "log", "Lorg/slf4j/Logger;");
                mv.visitLdcInsn("info {} , {} , {}");
                mv.visitInsn(Opcodes.ICONST_3);
                mv.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object");
                mv.visitInsn(Opcodes.DUP);
                mv.visitInsn(Opcodes.ICONST_0);
                mv.visitVarInsn(Opcodes.ALOAD, 2);
                mv.visitInsn(Opcodes.AASTORE);
                mv.visitInsn(Opcodes.DUP);
                mv.visitInsn(Opcodes.ICONST_1);
                mv.visitVarInsn(Opcodes.ALOAD, 1);
                mv.visitInsn(Opcodes.AASTORE);
                mv.visitInsn(Opcodes.DUP);
                mv.visitInsn(Opcodes.ICONST_2);
                mv.visitVarInsn(Opcodes.ILOAD, 0);
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
                mv.visitInsn(Opcodes.AASTORE);
                mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/slf4j/Logger", "info", "(Ljava/lang/String;[Ljava/lang/Object;)V", true);
                Label l1 = new Label();
                mv.visitLabel(l1);
                mv.visitLineNumber(32, l1);
                mv.visitInsn(Opcodes.RETURN);
                Label l2 = new Label();
                mv.visitLabel(l2);
                mv.visitLocalVariable("a", "I", null, l0, l2, 0);
                mv.visitLocalVariable("b", "Ljava/lang/String;", null, l0, l2, 1);
                mv.visitLocalVariable("list", "Ljava/util/List;", "Ljava/util/List<Ljava/lang/String;>;", l0, l2, 2);
                mv.visitMaxs(6, 3);
                mv.visitEnd();

                // byte code end
//                TransformTarget.printSomething();
            }
            return mv;
        }
    }
}
