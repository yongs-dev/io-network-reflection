package mark.ionetworkreflection.javaadv2.network.tcp.v3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

/**
 * <b>ServerV3의 문제</b><br>
 * 클라이언트의 연결을 직접 종료하면 SessionV3에서 Exception 발생<br>
 * 이때 자원 해제(close)가 정상적으로 수행되지 않는다.<br>
 * 자바 객체는 GC가 되지만 자바 외부의 자원은 자동으로 GC되지 않는다.
 */
public class ServerV3 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();  // Blocking
            log("소켓 연결: " + socket);

            SessionV3 session = new SessionV3(socket);
            Thread thread = new Thread(session);
            thread.start();
        }
    }
}
