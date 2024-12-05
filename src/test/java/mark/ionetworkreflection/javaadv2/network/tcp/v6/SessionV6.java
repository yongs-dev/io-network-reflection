package mark.ionetworkreflection.javaadv2.network.tcp.v6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static mark.ionetworkreflection.javaadv2.network.tcp.SocketCloseUtil.closeAll;
import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

/**
 * <b>try-with-resources</b>는 사용과 해제를 함께 묶어서 처리할 때 사용한다.<br>
 * 하지만 Shutdown-Hook과 같은 케이스에서는 Session 안에 있는 try-with-resources를 통해 처리할 수 없다.
 */
public class SessionV6 implements Runnable {

    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final SessionManagerV6 sessionManager;
    private boolean closed = false;

    public SessionV6(Socket socket, SessionManagerV6 sessionManager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.sessionManager = sessionManager;
        sessionManager.add(this);
    }

    @Override
    public void run() {
        try {
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
        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            close();
        }
    }

    public synchronized void close() {
        if (closed) {
            return ;
        }

        closeAll(socket, input, output);
        closed = true;

        log("연결 종료: " + socket);
    }
}
