package mark.ionetworkreflection.javaadv2.io.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class OldFileTest {

    @Test
    void oldFileTest() throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");
        log.info("File exists: {}", file.exists());

        log.info("File created: {}", file.createNewFile());
        log.info("Directory created: {}", directory.mkdir());

        log.info("is file: {}", file.exists());
        log.info("is directory: {}", file.isDirectory());

        log.info("file name: {}", file.getName());
        log.info("file size: {} bytes", file.length());

//        log.info("file deleted: {}", file.delete());
//        log.info("directory deleted: {}", directory.delete());

        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        log.info("File renamed: {}", renamed);

        long lastModified = file.lastModified();
        log.info("Last modified: {}", new Date(lastModified));
    }
}
