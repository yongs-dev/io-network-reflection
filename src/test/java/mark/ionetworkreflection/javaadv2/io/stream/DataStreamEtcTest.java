package mark.ionetworkreflection.javaadv2.io.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;

@Slf4j
public class DataStreamEtcTest {

    @Test
    void dataStreamTest() throws Exception {
        FileOutputStream fos = new FileOutputStream("temp/data.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("회원A");
        dos.writeInt(20);
        dos.writeDouble(10.5);
        dos.writeBoolean(true);
        dos.close();

        FileInputStream fis = new FileInputStream("temp/data.dat");
        DataInputStream dis = new DataInputStream(fis);
        log.info("{}, {}, {}, {}", dis.readUTF(), dis.readInt(), dis.readDouble(), dis.readBoolean());
    }
}
