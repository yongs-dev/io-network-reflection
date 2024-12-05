package mark.ionetworkreflection.javaadv2.network.exception.close.reset;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

public class ResetCloseClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        // client <- server: FIN
        Thread.sleep(1000); // 서버가 close() 호출할 때 까지 잠시 대기

        // client -> server: PUSH[1]
        output.write(1);

        // client <- server: RST(Reset 패킷은 연결 상태를 초기화해서 더 이상 현재의 연결을 유지하지 않겠다는 의미를 전달한다.
        Thread.sleep(1000); // RST 패킷 전송 대기

        try {
            // RST 패킷이 도착하면 자바는 read()로 메시지를 읽을 때 아래 예외를 던짐
            int read = input.read();
            log("read = " + read);
        } catch (SocketException e) {
            // java.net.SocketException: Connection reset
            e.printStackTrace();
        }

        try {
            // RST 패킷이 도착하면 자바는 write()로 메시지를 전송할 때 아래 예외를 던짐
            output.write(1);
        } catch (SocketException e) {
            // java.net.SocketException: Broken pipe
            e.printStackTrace();
        }

        log("연결 종료: " + socket.isClosed());
    }
}
