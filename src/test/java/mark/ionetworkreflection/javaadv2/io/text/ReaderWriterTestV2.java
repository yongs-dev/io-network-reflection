package mark.ionetworkreflection.javaadv2.io.text;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;
import static mark.ionetworkreflection.javaadv2.io.text.TextConst.FILE_NAME;

@Slf4j
public class ReaderWriterTestV2 {

    @Test
    void readerWriterTest() throws IOException {
        String writeString = "ABC";
        log.info("write String: {}", writeString);

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);

        osw.write(writeString);
        osw.close();

        // 파일 읽기
        StringBuilder content = new StringBuilder();
        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);

        int ch;
        while ((ch = isr.read()) != -1) {
            content.append((char) ch);
        }
        isr.close();

        log.info("read String: {}", content);
    }
}
