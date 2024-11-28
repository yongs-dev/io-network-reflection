package mark.ionetworkreflection.javaadv2.io.file.text;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class ReadTextFileV1Test {

    private static final String PATH = "temp/hello2.txt";

    @Test
    void v1Test() throws IOException {
        String writeString = "ABC\n가나다";
        log.info("== Write String ==\n{}", writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, UTF_8);

        // 파일에서 읽기
        String readString = Files.readString(path, UTF_8);
        log.info("== Read String ==\n{}", readString);
    }
}
