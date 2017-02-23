package thread;

/**
 * Created by mortli on 2/23/17.
 */
public enum DatePatternEnum {


        TimePattern("yyyy-MM-dd HH:mm:ss"),

        DatePattern("yyyy-MM-dd"),
            ;

        public String pattern;

        private DatePatternEnum(String pattern) {
            this.pattern = pattern;
        }

}
