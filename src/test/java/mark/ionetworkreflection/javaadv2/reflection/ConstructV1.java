package mark.ionetworkreflection.javaadv2.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class ConstructV1 {

    @Test
    void constructV1Test() throws Exception {
        Class<?> aClass = Class.forName("mark.ionetworkreflection.javaadv2.reflection.data.BasicData");

        // 생성자는 상속의 개념이 없음
        System.out.println("===== constructors() ===== ");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }

        // private 접근 제어자도 조회
        System.out.println("===== declaredConstructors() ===== ");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
    }
}
