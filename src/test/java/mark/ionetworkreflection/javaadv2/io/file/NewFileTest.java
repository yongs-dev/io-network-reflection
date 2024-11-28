package mark.ionetworkreflection.javaadv2.io.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

@Slf4j
public class NewFileTest {

    @Test
    void newFileTest() throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        log.info("File exists: {}", Files.exists(file));

        try {
            Files.createFile(file);
            log.info("File created");
        } catch (FileAlreadyExistsException e) {
            log.error("{} already exists", file.getFileName());
        }

        try {
            Files.createDirectory(directory);
            log.info("Directory created");
        } catch (FileAlreadyExistsException e) {
            log.error("{} already exists", directory.getFileName());
        }

        log.info("is regular file: {}", Files.isRegularFile(file));
        log.info("is directory: {}", Files.isDirectory(directory));
        log.info("File name: {}", file.getFileName());
        log.info("File size: {} bytes", Files.size(file));

        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        log.info("File moved/renamed");

        log.info("Last modified: {}", Files.getLastModifiedTime(newFile));

        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        log.info("===== Attributes =====");
        log.info("Creation time: {}", attrs.creationTime());
        log.info("is directory: {}", attrs.isDirectory());
        log.info("is regular file: {}", attrs.isRegularFile());
        log.info("is symbolic link: {}", attrs.isSymbolicLink());
        log.info("Size: {}", attrs.size());

//        Files.delete(file);
//        log.info("File deleted");
    }
}
