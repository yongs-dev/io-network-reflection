package mark.ionetworkreflection.javaadv2.annotation.basic.inherited;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

/**
 * <ol>
 *     <li>클래스 상속과 인터페이스 구현의 차이</li>
 *     <ul>
 *         <li>클래스 상속은 자식 클래스가 부모 클래스의 속성과 메서드를 상속받는 개념이다. 즉 자식 클래스는 부모 클래스의 특성을 이어 받으므로 애노테이션을 상속받을 수 있는 논리적인 기반이 있다.</li>
 *         <li>인터페이스는 메서드의 시그니처만을 정의할 뿐 상태나 행위를 가지지 않기 때문에 인터페이스의 구현체가 애노테이션을 상속한다는 개념이 잘 맞지 않는다.</li>
 *     </ul>
 *     <li>인터페이스와 다중 구현, 다이아몬드 문제</li>
 *     <ul>
 *         <li>인터페이스는 다중 구현이 가능하다. 만약 인터페이스의 애노테이션을 구현 클래스에서 상속하게 되면 여러 인터페이스의 애노테이션 간의 충돌이나 모호한 상황이 발생할 수 있다.</li>
 *     </ul>
 * </ol>
 */
public class InheritedTest {

    @Test
    void inheritedTest() {
        print(Parent.class);
        print(Child.class);
        print(TestInterface.class);
        print(TestInterfaceImpl.class);
    }

    private void print(Class<?> clazz) {
        System.out.println("class: " + clazz);
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(" - " + annotation.annotationType().getSimpleName());
        }
        System.out.println();
    }
}
