package mark.ionetworkreflection.javaadv2.reflection;

import mark.ionetworkreflection.javaadv2.reflection.data.BasicData;
import org.junit.jupiter.api.Test;

public class BasicV1 {

    @Test
    void basicV1Test() throws ClassNotFoundException {
        // 클래스 메타데이터 조회 방법 3가지

        // 1. 클래스에서 찾기
        Class<BasicData> basicDataClass1 = BasicData.class;
        System.out.println("basicDataClass1 = " + basicDataClass1);

        // 2. 인스턴스에서 찾기
        BasicData basicInstance = new BasicData();
        Class<? extends BasicData> basicDataClass2 = basicInstance.getClass();
        System.out.println("basicDataClass2 = " + basicDataClass2);

        // 3. 문자로 찾기
        String className = "mark.ionetworkreflection.javaadv2.reflection.data.BasicData";
        Class<?> basicDataClass3 = Class.forName(className);
        System.out.println("basicDataClass3 = " + basicDataClass3);
    }
}
