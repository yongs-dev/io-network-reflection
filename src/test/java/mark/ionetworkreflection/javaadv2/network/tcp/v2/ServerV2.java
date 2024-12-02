package mark.ionetworkreflection.javaadv2.network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

/**
 * <b>ServerV2의 문제</b>
 * <ul>
 *     <li>1. 새로운 클라이언트가 접속하면?</li>
 *     - 새로운 클라이언트가 접속했을 때 서버의 main 스레드는 accept() 메서드를 호출할 수 없다. 왜냐하면 while 문으로 기존 클라이언트와 메시지를 주고 받는 부분만 반복하기 때문이다.<br>
 *     - accept()를 호출해야 소켓 객체를 생성하고 클라이언트와 메시지를 주고 받을 수 있다.
 *     <li>2. 2개의 블로킹 작업 - 별도 스레드 필요</li>
 *     - accept(): 클라이언트와 서버의 연결을 처리하기 위해 대기<br>
 *     - readXxx(): 클라이언트의 메시지를 받아서 치라하기 위해 대기<br>
 *     - 각각의 블로킹 작업은 별도의 스레드에서 처리해야 한다. 그렇지 않으면 다른 블로킹 메서드 때문에 계속 대기할 수 있다.
 * </ul>
 */
public class ServerV2 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        Socket socket = serverSocket.accept();  // Blocking
        log("소켓 연결: " + socket);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        while (true) {
            // 클라이언트로부터 문자 받기
            String received = input.readUTF();  // Blocking
            log("client -> server: " + received);

            if (received.equals("exit")) {
                break;
            }

            // 클라이언트에게 문자 보내기
            String toSend = received + " World!";
            output.writeUTF(toSend);
            log("client <- server: " + toSend);
        }

        // 자원 종료
        log("연결 종료: " + socket);

        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}
