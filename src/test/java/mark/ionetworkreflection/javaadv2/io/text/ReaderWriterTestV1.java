package mark.ionetworkreflection.javaadv2.io.text;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;
import static mark.ionetworkreflection.javaadv2.io.text.TextConst.FILE_NAME;

@Slf4j
public class ReaderWriterTestV1 {

    /**
     * <ul>
     *     <li>스트림은 byte만 사용할 수 있으므로 String과 같은 문자는 직접 전달할 수 없다.</li>
     *     <li>개발자가 번거롭게 변환 과정을 직접 호출해야한다.</li>
     *     <li>String + 문자 집합 -> byte[]</li>
     *     <li>byte[] + 문자 집합 -> String</li>
     * </ul>
     */
    @Test
    void readerWriterTest() throws IOException {
        String writeString = "ABC";
        
        // 문자 - byte UTF-8 인코딩
        byte[] writeBytes = writeString.getBytes(UTF_8);
        log.info("write String: {}, write bytes: {}", writeString, Arrays.toString(writeBytes));

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writeBytes);
        fos.close();

        // 파일에서 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readBytes = fis.readAllBytes();
        fis.close();

        // byte -> String UTF-8 Decoding
        String readString = new String(readBytes, UTF_8);
        log.info("read bytes: {}, read String: {}", Arrays.toString(readBytes), readString);
    }
}
