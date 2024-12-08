package mark.ionetworkreflection.javaadv2.annotation.mapping;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class TestControllerTest {

    @Test
    void test() {
        TestController testController = new TestController();

        Class<? extends TestController> aClass = testController.getClass();
        for (Method method : aClass.getDeclaredMethods()) {
            SimpleMapping simpleAnnotation = method.getAnnotation(SimpleMapping.class);
            if (simpleAnnotation != null) {
                System.out.println("[" + simpleAnnotation.value() + "] -> " + method);
            }
        }
    }
}
