package mark.ionetworkreflection.javaadv2.reflection;

import mark.ionetworkreflection.javaadv2.reflection.data.BasicData;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MethodV1 {

    @Test
    void methodV1Test() {
        Class<BasicData> helloClass = BasicData.class;

        // 해당 클래스와 상위 클래스에서 상속된 모든 public 메서드를 반환
        System.out.println("===== methods() =====");
        Method[] methods = helloClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        // 해당 클래스에서 선언된 모든 메서드를 반환하며, 접근 제어자에 관계없이 반환. 상속된 메서드는 포함되지 않음
        System.out.println("===== declaredMethods() =====");
        Method[] declaredMethods = helloClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
    }
}
