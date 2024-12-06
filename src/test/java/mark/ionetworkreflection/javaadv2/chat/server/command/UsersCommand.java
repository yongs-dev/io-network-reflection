package mark.ionetworkreflection.javaadv2.chat.server.command;

import lombok.RequiredArgsConstructor;
import mark.ionetworkreflection.javaadv2.chat.server.Session;
import mark.ionetworkreflection.javaadv2.chat.server.SessionManager;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class UsersCommand implements Command {

    private final SessionManager sessionManager;

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<String> usernames = sessionManager.getAllUsername();
        StringBuilder sb = new StringBuilder();
        sb.append("전체 접속자 : ").append(usernames.size()).append("\n");
        for (String username : usernames) {
            sb.append(" - ").append(username).append("\n");
        }
        session.send(sb.toString());
    }
}
