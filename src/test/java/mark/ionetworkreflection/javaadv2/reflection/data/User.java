package mark.ionetworkreflection.javaadv2.reflection.data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String id;
    private String name;
    private Integer age;
}
