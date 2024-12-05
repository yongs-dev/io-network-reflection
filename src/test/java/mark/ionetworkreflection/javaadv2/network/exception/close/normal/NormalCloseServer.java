package mark.ionetworkreflection.javaadv2.network.exception.close.normal;

import java.net.ServerSocket;
import java.net.Socket;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

public class NormalCloseServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);

        Thread.sleep(1000);
        socket.close(); // Client에게 연결 종료를 위한 FIN 패킷 전송
        serverSocket.close();
        log("소켓 종료: " + socket);
    }
}
