package mark.ionetworkreflection.javaadv2.network.exception.connect;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

public class ConnectTimeoutTestV1 {

    /**
     * <ul>
     *     <b>java.net.ConnectException: Operation timed out</b>
     *     <li>해당 IP로 연결 패킷을 보내지만 IP를 사용하는 서버가 없으므로 TCP 응답이 오지 않는다.</li>
     *     <li>해당 IP로 연결 패킷을 보내지만 해당 서버가 너무 바쁘거나 문제가 있어 연결 응답 패킷을 보내지 못하는 경우도 있다.</li>
     *     <hr>
     *     <b>OS 기본 대기시간</b>
     *     <li>Windows: 약 21초</li>
     *     <li>Linux: 약 75초 ~ 180초 사이</li>
     *     <li>Mac: 약 75초</li>
     * </ul>
     */
    @Test
    void connectTimeoutTest() throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket("192.168.1.250", 45678); // 사설 IP 대역(주로 공유기에서 사용하는 IP대역)의 192.168.1.250을 사용
        } catch (ConnectException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        log("elapsed time: " + (end - start));
    }
}
