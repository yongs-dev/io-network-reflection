package mark.ionetworkreflection.javaadv2.reflection;

import mark.ionetworkreflection.javaadv2.reflection.data.BasicData;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldV1 {

    @Test
    void fieldV1Test() {
        Class<BasicData> helloClass = BasicData.class;

        // 해당 클래스와 상위 클래스에서 상속된 모든 public 필드를 반환
        System.out.println("===== fields() =====");
        Field[] fields = helloClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        // 해당 클래스에서 선언된 모든 필드를 반환하며, 접근 제어자에 관계없이 반환. 상속된 필드는 포함하지 않음
        System.out.println("===== declaredFields() =====");
        Field[] declaredFields = helloClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
    }
}
