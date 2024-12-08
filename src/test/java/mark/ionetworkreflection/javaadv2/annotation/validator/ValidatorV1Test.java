package mark.ionetworkreflection.javaadv2.annotation.validator;

import org.junit.jupiter.api.Test;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

public class ValidatorV1Test {

    @Test
    void validatorV1Test() {
        User user = new User("user1", 0);
        Team team = new Team("", 0);

        try {
            log("== user 검증 ==");
            validateUser(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            log("== team 검증 ==");
            validateTeam(team);
        } catch (Exception e) {
            log(e);
        }
    }

    private void validateUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new RuntimeException("이름이 비어있습니다.");
        }

        if (user.getAge() < 1 || user.getAge() > 100) {
            throw new RuntimeException("나이는 1과 100사이입니다.");
        }
    }

    private void validateTeam(Team team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new RuntimeException("이름이 비어있습니다.");
        }

        if (team.getMemberCount() < 1 || team.getMemberCount() > 999) {
            throw new RuntimeException("회원 수는 1과 999 사이어야 합니다.");
        }
    }
}
