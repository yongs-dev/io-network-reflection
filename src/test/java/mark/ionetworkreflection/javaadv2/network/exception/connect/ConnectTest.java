package mark.ionetworkreflection.javaadv2.network.exception.connect;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectTest {

    @Test
    void connectTest() throws IOException {
        unknownHostEx1();
        unknownHostEx2();
        connectionRefused();
    }

    // IP 대역이 잘못 됨
    private void unknownHostEx1() throws IOException {
        try {
            Socket socket = new Socket("999.999.999.999", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    // DNS에 도메인이 없음
    private void unknownHostEx2() throws IOException {
        try {
            Socket socket = new Socket("google.gogo", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * <ul>
     *     <b>Connection Refused</b>
     *     <li>연결이 거절. 네트워크를 통해 해당 IP의 서버 컴퓨터에 접속은 했다는 뜻이다.</li>
     *     <li>IP에 해당하는 서버는 켜져있지만, 사용하는 PORT가 없을 때 주로 발생</li>
     *     <li>네트워크 방화벽 등에서 무단 연결로 인지하고 연결을 막을 떄도 발생</li>
     *     <li>서버 컴퓨터의 OS는 이때 TCP RST(Reset) 패킷을 보내서 연결을 거절한다. 클라이언트에서 RST 패킷을 받으면 해당 오류 발생</li>
     * </ul>
     */
    private void connectionRefused() throws IOException {
        try {
            Socket socket = new Socket("localhost", 45678);
        } catch (ConnectException e) {

        }
    }
}
