package mark.ionetworkreflection.javaadv2.annotation.basic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ElementData1Test {

    @Test
    void elementDataTest() {
        Class<ElementData1> annoClass = ElementData1.class;
        AnnoElement annotation = annoClass.getAnnotation(AnnoElement.class);

        String value = annotation.value();
        System.out.println("value = " + value);

        int count = annotation.count();
        System.out.println("count = " + count);

        String[] tags = annotation.tags();
        System.out.println("tags = " + Arrays.toString(tags));
    }
}
