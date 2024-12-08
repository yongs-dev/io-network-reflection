package mark.ionetworkreflection.javaadv2.annotation.validator;

import org.junit.jupiter.api.Test;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

public class ValidatorV2Test {

    @Test
    void validatorV2Test() {
        User user = new User("user1", 0);
        Team team = new Team("", 0);

        try {
            log("== user 검증 ==");
            Validator.validate(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            log("== team 검증 ==");
            Validator.validate(team);
        } catch (Exception e) {
            log(e);
        }
    }
}
