package mark.ionetworkreflection.javaadv2.reflection;

import mark.ionetworkreflection.javaadv2.reflection.data.Team;
import mark.ionetworkreflection.javaadv2.reflection.data.User;
import org.junit.jupiter.api.Test;

public class FieldV4 {

    @Test
    void fieldV4Test() throws Exception {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("===== before =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        System.out.println("===== after =====");
        FieldUtil.nullFieldToDefault(user);
        System.out.println("user = " + user);
        FieldUtil.nullFieldToDefault(team);
        System.out.println("team = " + team);
    }
}
