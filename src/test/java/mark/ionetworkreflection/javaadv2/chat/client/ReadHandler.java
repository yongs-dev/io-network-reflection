package mark.ionetworkreflection.javaadv2.chat.client;

import lombok.RequiredArgsConstructor;

import java.io.DataInputStream;
import java.io.IOException;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

@RequiredArgsConstructor
public class ReadHandler implements Runnable {

    private final DataInputStream input;
    private final Client client;
    public boolean closed = false;

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                log(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    public synchronized void close() {
        if (closed) return;

        closed = true;
        log("readHandler 종료");
    }
}
