package mark.ionetworkreflection.javaadv2.network.exception.close.reset;

import java.net.ServerSocket;
import java.net.Socket;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

/**
 * <ul>
 *     <li>상대방이 연결을 종료한 경우 데이터를 읽으면 EOF 발생</li>
 *     -1, null, EOFException 등이 발생하며 이 경우 연결을 끊어야 한다.
 *     <li>java.net.SocketException: Connection reset</li>
 *     RST 패킷을 받은 이후에 read() 호출
 *     <li>java.net.SocketException: Broken pipe</li>
 *     RST 패킷을 받은 이후에 write() 호출
 *     <li>java.net.SocketException: Socket is closed</li>
 *     자신이 소켓을 닫은 이후에 read(), write() 호출
 * </ul>
 * <hr>
 * 기본적으로 정상 종료, 강제 종료 모두 <b>자원 정리하고 닫도록 설계</b>하면 된다.
 */
public class ResetCloseServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);

        socket.close(); // Client에게 연결 종료를 위한 FIN 패킷 전송
        serverSocket.close();
        log("소켓 종료: " + socket);
    }
}
