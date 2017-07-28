package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mortli on 2/23/17.
 */
public class SafeDataFormate {

    // SimpleDateFormat   对象创建很耗时 线程不安全  通过threadlocal 线程内部变量 共享对象 实现servlet 共享SimpleDateFormat

    private static final Map<DatePatternEnum, ThreadLocal<DateFormat>> pattern2ThreadLocal ;

    private static final Map<DatePatternEnum, ThreadLocal<List<DateFormat>>> pattern2ThreadLocal2 ;





    static {

        pattern2ThreadLocal2 = new HashMap<>();

        pattern2ThreadLocal = new HashMap<DatePatternEnum, ThreadLocal<DateFormat>>(DatePatternEnum.values().length);

        DatePatternEnum[] patterns = DatePatternEnum.values();

        for (int i = 0; i < patterns.length; i++) {

            DatePatternEnum patternEnum = patterns[i];
            final String pattern = patternEnum.pattern;

            pattern2ThreadLocal.put(patterns[i] , new ThreadLocal<DateFormat> (){
                @Override
                protected DateFormat initialValue() {
                    return new SimpleDateFormat(pattern);
                }
            });
        }
    }


    public static DateFormat getDateFormatByPattern(DatePatternEnum pattern){
        ThreadLocal<DateFormat> threadLocal =   pattern2ThreadLocal.get(pattern);
        return  threadLocal.get();
    }

}
