package mark.ionetworkreflection.javaadv2.io.text;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static mark.ionetworkreflection.javaadv2.io.text.TextConst.FILE_NAME;

@Slf4j
public class ReaderWriterTestV3 {

    @Test
    void readerWriterTest() throws IOException {
        String writeString = "ABC";
        log.info("write String: {}", writeString);

        // 파일에 쓰기
        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        fw.write(writeString);
        fw.close();

        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);

        int ch;
        while ((ch = fr.read()) != -1) {
            content.append((char) ch);
        }
        fr.close();

        log.info("read String: {}", content);
    }
}
