package mark.ionetworkreflection.javaadv2.annotation.java;

import org.junit.jupiter.api.Test;

public class DeprecatedTest {

    @Test
    public void test() {
        System.out.println("DeprecatedTest");
        DeprecatedClass dc = new DeprecatedClass();
        dc.call1();
        dc.call2(); // IDE 경고
        dc.call3(); // IDE 경고(심각)
    }
}
