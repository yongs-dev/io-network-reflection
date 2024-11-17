package character;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

@Slf4j
public class AvailableCharactersTest {

    @Test
    public void availableCharactersTest() {
        // 이용 가능한 모든 CharacterSet 자바 + OS
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (String charsetName : charsets.keySet()) {
            log.info("charsetName = {}", charsetName);
        }

        log.info("=====");

        // 문자로 조회(대소문자 구분 X)
        Charset charset1 = Charset.forName("MS949");
        log.info("charset1 = {}", charset1);

        // 별칭 조회
        Set<String> aliases = charset1.aliases();
        for (String alias : aliases) {
            log.info("alias = {}", alias);
        }

        // UTF-8 문자로 조회
        Charset charset2 = Charset.forName("UTF-8");
        log.info("charset2 = {}", charset2);

        // UTF-8 상수로 조회
        Charset charset3 = StandardCharsets.UTF_8;
        log.info("charset3 = {}", charset3);

        // 시스템의 기본 Charset 조회
        Charset charset4 = Charset.defaultCharset();
        log.info("charset4 = {}", charset4);
    }
}
