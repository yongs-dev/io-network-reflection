package mark.ionetworkreflection.javaadv2.io.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class OldFilePathTest {

    @Test
    void oldFilePathTest() throws IOException {
        File file = new File("temp/..");
        log.info("path = {}", file.getPath());

        // 절대 경로
        log.info("Absolute path = {}", file.getAbsolutePath());

        // 정규 경로
        log.info("Canonical path = {}", file.getCanonicalPath());

        for (File f : Objects.requireNonNull(file.listFiles())) {
            log.info("{} | {}", f.isFile() ? "F" : "D", f.getName());
        }
    }
}
