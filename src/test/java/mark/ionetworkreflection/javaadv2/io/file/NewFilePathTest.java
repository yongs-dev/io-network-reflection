package mark.ionetworkreflection.javaadv2.io.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class NewFilePathTest {

    @Test
    void newFilePathTest() throws IOException {
        Path path = Path.of("temp/..");
        log.info("path = {}", path);

        // 절대 경로
        log.info("Absolute path = {}", path.toAbsolutePath());

        // 정규 경로
        log.info("Canonical path = {}", path.toRealPath());

        Stream<Path> pathStream = Files.list(path);
        List<Path> list = pathStream.toList();
        pathStream.close();

        for (Path p : list) {
            log.info("{} | {}", Files.isRegularFile(p) ? "F" : "D", p.getFileName());
        }
    }
}
