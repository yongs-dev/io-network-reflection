package mark.ionetworkreflection.javaadv2.io.stream;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEtcTest {

    @Test
    void printStreamTest() throws Exception {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream ps = new PrintStream(fos);

        ps.println("hello java!");
        ps.println(10);
        ps.println(true);
        ps.printf("hello %s", "world");
        ps.close();
    }
}
