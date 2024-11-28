package mark.ionetworkreflection.javaadv2.io.file.copy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class CreateCopyFileTest {

    private static final int FILE_SIZE = 200 * 1024 * 1024;

    @Test
    void createCopyFileTest() throws IOException {
        long startTime = System.currentTimeMillis();
        String fileName = "temp/copy.dat";

        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[FILE_SIZE];
        fos.write(buffer);
        fos.close();

        long endTime = System.currentTimeMillis();
        log.info("File created: {}, File Size: {} bytes, Time token: {} ms", fileName, FILE_SIZE, endTime - startTime);
    }
}
