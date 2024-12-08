package mark.ionetworkreflection.javaadv2.reflection;

import mark.ionetworkreflection.javaadv2.reflection.data.Team;
import mark.ionetworkreflection.javaadv2.reflection.data.User;
import org.junit.jupiter.api.Test;

public class FieldV3 {

    @Test
    void fieldV3Test() throws Exception {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("===== before =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        // 클래스의 모든 필드를 전부다 체크해야함
        if (user.getId() == null) {
            user.setId("");
        }

        if (team.getId() == null) {
            team.setId("");
        }
    }
}
