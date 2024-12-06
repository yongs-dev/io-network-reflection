package mark.ionetworkreflection.javaadv2.chat.server.command;

import lombok.RequiredArgsConstructor;
import mark.ionetworkreflection.javaadv2.chat.server.Session;
import mark.ionetworkreflection.javaadv2.chat.server.SessionManager;

@RequiredArgsConstructor
public class MessageCommand implements Command {

    private final SessionManager sessionManager;

    @Override
    public void execute(String[] args, Session session) {
        String message = args[1];
        sessionManager.sendAll("[" + session.getUsername() + "] " + message);
    }
}
