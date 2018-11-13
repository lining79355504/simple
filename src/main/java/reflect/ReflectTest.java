package reflect;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:  lining17
 * Date :  2018/11/13
 */
public class ReflectTest {


    private static final Logger logger = LoggerFactory.getLogger(ReflectTest.class);

    /**
     * @param paramA
     * @param paramB
     * @return
     */
    public Integer methodA(String paramA , Integer paramB){

        return new Integer(Integer.parseInt(paramA) + paramB);

    }


    public static void main(String[] args) {
        Class<?>[] parameterTypes = new Class<?>[2];

        parameterTypes[0] = String.class;
        parameterTypes[1] = Integer.class;

        Object[] params = new Object[2];
        params[0]="4";
        params[1]=Integer.valueOf(3);


        Class<?> clazz =  ReflectTest.class;
        try {

            Method method = clazz.getMethod("methodA",parameterTypes);
            Object ret = method.invoke(new ReflectTest(), params);
            logger.info("ret is  {}" , JSON.toJSONString(ret));
            logger.info("ret is  {}" , ret);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }




}
