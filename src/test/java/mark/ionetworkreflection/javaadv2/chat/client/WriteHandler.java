package mark.ionetworkreflection.javaadv2.chat.client;

import lombok.RequiredArgsConstructor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

@RequiredArgsConstructor
public class WriteHandler implements Runnable {

    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;

    private boolean closed = false;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            log("이름을 입력하세요.");
            String username = inputUsername(scanner);
            output.writeUTF("/join" + DELIMITER + username);

            while (true) {
                String toSend = scanner.nextLine(); // Blocking
                if (toSend.isEmpty()) {
                    continue;
                }

                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    continue;
                }

                // "/" 시작하면 명령어, 나머지는 일반 메시지
                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                    continue;
                } else {
                    output.writeUTF("/message" + DELIMITER + toSend);
                }
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }

    }

    private static String inputUsername(Scanner scanner) {
        String username;

        do {
            username = scanner.nextLine();
        } while (username.isEmpty());

        return username;
    }

    public synchronized void close() {
        if (closed) return;

        try {
            System.in.close(); // Scanner 입력 중지 (사용자의 입력을 닫음)
        } catch (IOException e) {
            log(e);
        }

        closed = true;
        log("writeHandler 종료");
    }
}
