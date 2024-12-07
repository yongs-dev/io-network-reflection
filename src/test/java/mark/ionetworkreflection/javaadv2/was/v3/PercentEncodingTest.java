package mark.ionetworkreflection.javaadv2.was.v3;

import org.junit.jupiter.api.Test;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PercentEncodingTest {

    @Test
    void percentEncodingTest() {
        String encode = URLEncoder.encode("가", StandardCharsets.UTF_8);
        System.out.println("encode = " + encode);

        String decode = URLDecoder.decode(encode, StandardCharsets.UTF_8);
        System.out.println("decode = " + decode);
    }
}
