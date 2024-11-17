package mark.ionetworkreflection.javaadv2.character;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Slf4j
public class CharacterSetTest {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    @Test
    public void encodingTest() {
        log.info("== ASCII 영문 처리==");
        encoding("A", StandardCharsets.US_ASCII);
        encoding("A", StandardCharsets.ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", StandardCharsets.UTF_8);
        encoding("A", StandardCharsets.UTF_16BE);

        log.info("== 한글 지원 ==");
        encoding("가", EUC_KR);
        encoding("가", MS_949);
        encoding("가", StandardCharsets.UTF_8);
        encoding("가", StandardCharsets.UTF_16BE);

        String str = "A";
        byte[] bytes = str.getBytes();
        log.info("bytes = {}", Arrays.toString(bytes));
    }

    @Test
    public void encodingAndDecoding() {
        log.info("== 영문 ASCII 인코딩 == ");
        encodingAndDecoding("A", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        encodingAndDecoding("A", StandardCharsets.US_ASCII, StandardCharsets.ISO_8859_1);   // ASCII 확장(LATIN-1)
        encodingAndDecoding("A", StandardCharsets.US_ASCII, EUC_KR);    // ASCII 포함
        encodingAndDecoding("A", StandardCharsets.US_ASCII, MS_949);    // ASCII 포함
        encodingAndDecoding("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_8);    // ASCII 포함
        encodingAndDecoding("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_16BE); // ASCII 포함 X

        log.info("== 한글 인코딩 - 기본 ==");
        encodingAndDecoding("가", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII); // X
        encodingAndDecoding("가", StandardCharsets.ISO_8859_1, StandardCharsets.ISO_8859_1); // X
        encodingAndDecoding("가", EUC_KR, EUC_KR); // O
        encodingAndDecoding("가", MS_949, MS_949); // O
        encodingAndDecoding("가", StandardCharsets.UTF_8, StandardCharsets.UTF_8); // O
        encodingAndDecoding("가", StandardCharsets.UTF_16BE, StandardCharsets.UTF_16BE); // O

        log.info("== 한글 인코딩 - 복잡한 문자 ==");
        encodingAndDecoding("뷁", EUC_KR, EUC_KR);   // X
        encodingAndDecoding("뷁", MS_949, MS_949);   // O
        encodingAndDecoding("뷁", StandardCharsets.UTF_8, StandardCharsets.UTF_8);   // O
        encodingAndDecoding("뷁", StandardCharsets.UTF_16BE, StandardCharsets.UTF_16BE);   // O

        log.info("== 한글 인코딩 - 디코딩이 다른 경우 ==");
        encodingAndDecoding("가", EUC_KR, MS_949);   // O
        encodingAndDecoding("뷁", MS_949, EUC_KR);   // 인코딩 O, 디코딩 X
        encodingAndDecoding("가", EUC_KR, StandardCharsets.UTF_8);   // X
        encodingAndDecoding("가", MS_949, StandardCharsets.UTF_8);   // X
        encodingAndDecoding("가", StandardCharsets.UTF_8, MS_949);   // X

        log.info("== 영문 인코딩 - 디코딩이 다른 경우 ==");
        encodingAndDecoding("A", EUC_KR, StandardCharsets.UTF_8);   // O
        encodingAndDecoding("A", MS_949, StandardCharsets.UTF_8);   // O
        encodingAndDecoding("A", StandardCharsets.UTF_8, MS_949);   // O
        encodingAndDecoding("A", StandardCharsets.UTF_8, StandardCharsets.UTF_16BE);   // X
    }

    private void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        log.info("{} -> [{}] 인코딩 -> {} {}byte", text, charset, Arrays.toString(bytes), bytes.length);
    }

    private void encodingAndDecoding(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);

        log.info("{} -> [{}] 인코딩 -> {} {}byte -> [{}] 디코딩 -> {}", text, encodingCharset, Arrays.toString(encoded), encoded.length, decodingCharset, decoded);
    }
}
