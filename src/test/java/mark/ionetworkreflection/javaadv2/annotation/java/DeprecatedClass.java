package mark.ionetworkreflection.javaadv2.annotation.java;

public class DeprecatedClass {
    public void call1() {
        System.out.println("DeprecatedClass.call1");
    }

    @Deprecated
    public void call2() {
        System.out.println("DeprecatedClass.call2");
    }

    // forRemoval: 미래에 지워질 가능성이 있음
    @Deprecated(since = "2.4", forRemoval = true)
    public void call3() {
        System.out.println("DeprecatedClass.call3");
    }
}
