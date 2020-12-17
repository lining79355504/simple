package reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author mort
 * @Description
 * @date 2020/12/17
 **/
public class FieldsCopy {

    private static final Logger logger = LoggerFactory.getLogger(FieldsCopy.class);

    public static void copyIfNull(Object source, Object target) {

        Class<?> sourceClass = source.getClass();

        Class<?> targetCls = target.getClass();
        Field[] targetDeclaredFields = targetCls.getDeclaredFields();
        for (int i = 0; i < targetDeclaredFields.length; i++) {
            Field f = targetDeclaredFields[i];
            f.setAccessible(true);
            try {
                Object value = f.get(target);
                String name = f.getName();
                System.out.println("属性名:" + name + " 属性值:" + value);
                if (null == value) {
                    Field sourceField = sourceClass.getDeclaredField(name);
                    sourceField.setAccessible(true);
                    f.set(target, sourceField.get(source));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        A a = new A();
        a.setAge(2);

        B b = new B();
        b.setAge(3);
        b.setStr("b");

        copyIfNull(b,a);
        System.out.println("args = " + Arrays.deepToString(args));
    }

    static class A {
        private String str;

        private Integer age;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    static class B {
        private String str;

        private Integer age;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }


}
