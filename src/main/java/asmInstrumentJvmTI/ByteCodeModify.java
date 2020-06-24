package asmInstrumentJvmTI;

import jdk.internal.org.objectweb.asm.*;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import jdk.internal.org.objectweb.asm.tree.MethodNode;

import java.io.FileInputStream;

/**
 * Author:  lining17
 * Date :  2020-06-12
 */
public class ByteCodeModify {


    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/mort/simple/src/main/java/asmInstrumentJvmTI/ByteCodeDemo.class");
        ClassReader classReader = new ClassReader(fileInputStream);
        ClassWriter cw = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        //Java8选择ASM5，
        ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM5, cw) {
            @Override
            public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
                System.out.println("field:" + name);
                return super.visitField(access, name, desc, signature, value);
            }

            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                System.out.println("方法" + name);
                return super.visitMethod(access, name, desc, signature, exceptions);
            }
        };
        //忽略调试信息
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);

        treeApi();

    }


    public static void treeApi() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("/Users/mort/simple/src/main/java/asmInstrumentJvmTI/ByteCodeDemo.class");
        ClassReader classReader = new ClassReader(fileInputStream);
        ClassWriter cw = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        //忽略调试信息
        ClassNode classNode = new ClassNode(org.objectweb.asm.Opcodes.ASM5);

        classReader.accept(classNode, ClassReader.SKIP_DEBUG);
        for (MethodNode methodNode:classNode.methods) {
            System.out.println(methodNode.name);
        }
        classNode.accept(cw);
    }

}
