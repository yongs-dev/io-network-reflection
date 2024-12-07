package mark.ionetworkreflection.javaadv2.was.v3;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

@RequiredArgsConstructor
public class HttpServerV3 {

    private final ExecutorService es = Executors.newFixedThreadPool(10);
    private final int port;

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("서버 시작 port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            es.submit(new HttpRequestHandlerV3(socket));
        }
    }
}
