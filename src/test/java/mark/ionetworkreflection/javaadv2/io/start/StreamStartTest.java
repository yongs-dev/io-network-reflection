package mark.ionetworkreflection.javaadv2.io.start;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class StreamStartTest {

    @Test
    public void streamStartTest() throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        log.info(String.valueOf(fis.read()));
        log.info(String.valueOf(fis.read()));
        log.info(String.valueOf(fis.read()));
        log.info(String.valueOf(fis.read()));
        fis.close();

        FileInputStream fis2 = new FileInputStream("temp/hello.dat");
        int data;
        while ((data = fis2.read()) != -1) { // -1 : EOF(End Of File)
            log.info(String.valueOf(data));
        }
        fis2.close();
    }

    @Test
    public void streamStartTest2() throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] input = new byte[]{65, 66, 67, 68};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10];
        int readCount = fis.read(buffer, 0, 10);
        log.info("readCount: {}, {}", readCount, Arrays.toString(buffer));
        fis.close();

        FileInputStream fis2 = new FileInputStream("temp/hello.dat");
        byte[] readAllBytes = fis2.readAllBytes();
        log.info("{}", Arrays.toString(readAllBytes));
        fis2.close();
    }
}
