package mark.ionetworkreflection.javaadv2.io.text;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;
import static mark.ionetworkreflection.javaadv2.io.text.TextConst.FILE_NAME;

@Slf4j
public class ReaderWriterTestV4 {

    private static final int BUFFER_SIZE = 8 * 1024;

    @Test
    void readerWriterTest() throws IOException {
        String writeString = "ABC\n가나다";
        log.info("== Write String ==\n{}", writeString);

        // 파일에 쓰기
        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();

        log.info("== Read String ==\n{}", content);
    }
}
