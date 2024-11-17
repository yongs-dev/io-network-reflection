package mark.ionetworkreflection.javaadv2.io.start;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Slf4j
public class StreamTypeTest {

    @Test
    public void byteArrayTest() throws IOException {
        byte[] input = {1, 2, 3};

        // 메모리에 쓰기
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(input);

        // 메모리에서 읽기
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        byte[] bytes = bis.readAllBytes();
        log.info(Arrays.toString(bytes));
    }

    @Test
    public void printStreamTest() throws IOException {
        PrintStream printStream = System.out;
        byte[] bytes = "Hello!\n".getBytes(StandardCharsets.UTF_8);
        printStream.write(bytes);
        printStream.println("Print!");
    }
}
