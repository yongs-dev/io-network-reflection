package mark.ionetworkreflection.javaadv2.network.exception.connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <ul>
 *     <b>java.net.SocketTimeoutException: Read timed out</b>
 *     <li>서버와 TCP 연결이 완료됐지만 서버가 응답을 주지 않을 때 발생한다.</li>
 * </ul>
 */
public class SoTimeoutServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();

        // 서버에서 응답을 하지 않아 클라이언트에서 Read timed out 오류 발생
        Thread.sleep(99999999);
    }
}
