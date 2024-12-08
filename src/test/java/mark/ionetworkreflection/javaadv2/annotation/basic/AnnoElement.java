package mark.ionetworkreflection.javaadv2.annotation.basic;

import mark.ionetworkreflection.javaadv2.util.MyLogger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {
    String value();
    int count() default 0;
    String[] tags() default {};

    // MyLogger annoData(); // 다른 타입은 적용할 수 없음
    Class<? extends MyLogger> annoData() default MyLogger.class;
}
