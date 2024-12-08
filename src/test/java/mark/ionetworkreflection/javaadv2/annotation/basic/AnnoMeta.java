package mark.ionetworkreflection.javaadv2.annotation.basic;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface AnnoMeta {
}
