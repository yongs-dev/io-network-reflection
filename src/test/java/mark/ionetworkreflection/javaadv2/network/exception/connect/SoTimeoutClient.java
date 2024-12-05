package mark.ionetworkreflection.javaadv2.network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();

        try {
            socket.setSoTimeout(3000); // 타임아웃 시간 설정. 해당 설정이 없으면 응답이 올 때 까지 무한 대기한다.
            int read = input.read();
            System.out.println("read = " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }

        socket.close();
    }
}
