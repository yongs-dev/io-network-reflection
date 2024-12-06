package mark.ionetworkreflection.javaadv2.chat.server;

import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class CommandManagerV1 implements CommandManager {

    private final SessionManager sessionManager;

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if (totalMessage.startsWith("/exit")) {
            throw new IOException("Exit");
        }

        sessionManager.sendAll(totalMessage);
    }
}
