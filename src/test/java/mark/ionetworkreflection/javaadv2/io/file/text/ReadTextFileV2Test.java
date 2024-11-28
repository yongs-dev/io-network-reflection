package mark.ionetworkreflection.javaadv2.io.file.text;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class ReadTextFileV2Test {

    private static final String PATH = "temp/hello2.txt";

    @Test
    void v2Test() throws IOException {
        String writeString = "ABC\n가나다";
        log.info("== Write String ==\n{}", writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, UTF_8);

        log.info("== Read String ==");
        
        // 메모리에 한번에 올림
        List<String> lines = Files.readAllLines(path, UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            log.info("{}: {}", i + 1, lines.get(i));
        }
        
        // 라인마다 메모리에 올림
        try (Stream<String> lineStream = Files.lines(path, UTF_8)) {
            lineStream.forEach(log::info);
        }
    }
}
