package serial;

import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Author:  lining17
 * Date :  2020-04-13
 */
public class Clone {

    private static  Unsafe U ;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            U = (Unsafe) theUnsafe.get("null");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //BeanUtils 根据反射实现的拷贝 必须有get set方法

    //object必须实现序列化接口 transient 不能被copy
    public static Object deepCloneWithSerialize(Object object) throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        oos.close();
        baos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Serializable obj = (Serializable) ois.readObject();
        ois.close();
        bais.close();
        return obj;
    }


    public static Object deepCloneWithUnsafe(Object object) {


        int baseOffset = U.arrayBaseOffset(object.getClass()); //对象的基本地址
        int addressSize = U.addressSize();
        return null;
    }


    private static Unsafe getUnsafeInstance() throws SecurityException, NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);

    }


    //Java Unsafe获取对象内存地址，对象成员变量相对对象内存地址偏移量以及通过这种方式获取对象成员变量的值
    public static long location(Object object) throws NoSuchFieldException, IllegalAccessException {

        Unsafe unsafe = getUnsafeInstance();
        Object[] array = new Object[]{object};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long location;

        switch (addressSize) {
            case 4:
                location = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                location = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);

        }

        return (location);

    }

    public static long getFieldOffset() throws NoSuchFieldException, IllegalAccessException {


        Unsafe unsafe = getUnsafeInstance();
        Student student = new Student();
        student.setName("ll");
        student.setAge(10);
        Field field = student.getClass().getDeclaredField("name");
        field.setAccessible(true);
        Object o = field.get(student); //反射获取的student name


        long valueOffset = unsafe.objectFieldOffset(field); //unsafe 获取的偏移地址
        o = unsafe.getObject(student, valueOffset);  //unsafe 获取的变量值。


        long baseLocation = location(student);  //unsafe获取对象基本地址。
//        o = unsafe.getO(baseLocation + valueOffset);  //只能获取原始类型变量么？
        return valueOffset;
    }

    public static void main(String[] args) {
        try {
            getFieldOffset();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
