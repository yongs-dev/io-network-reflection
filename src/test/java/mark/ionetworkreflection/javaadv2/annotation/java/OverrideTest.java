package mark.ionetworkreflection.javaadv2.annotation.java;

import org.junit.jupiter.api.Test;

public class OverrideTest {

    @Test
    void overrideTest() {
        A instance = new B();
        instance.call();
        instance.callSuccess();
//        instance.callFail();
    }

    static class A {
        public void call() {
            System.out.println("A.call");
        }

        public void callSuccess() {
            System.out.println("A.callSuccess");
        }
    }

    static class B extends A {

        @Override
        public void call() {
            System.out.println("B.call");
        }

        public void callFail() {
            System.out.println("B.callFail");
        }
    }
}
