package mark.ionetworkreflection.javaadv2.network.exception.connect;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

public class ConnectTimeoutTestV2 {

    /**
     * <ul>
     *     <b>java.net.SocketTimeoutException: Connect timed out</b>
     *     <li>타임아웃 시간이 지나도 연결이 되지 않으면 위 예외가 발생한다.</li>
     * </ul>
     */
    @Test
    void connectTimeoutTest() throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 3000);
        } catch (SocketTimeoutException e) {
           e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        log("elapsed time: " + (end - start));
    }
}
