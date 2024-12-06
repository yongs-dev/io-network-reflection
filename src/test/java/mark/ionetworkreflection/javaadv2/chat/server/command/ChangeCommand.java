package mark.ionetworkreflection.javaadv2.chat.server.command;

import lombok.RequiredArgsConstructor;
import mark.ionetworkreflection.javaadv2.chat.server.Session;
import mark.ionetworkreflection.javaadv2.chat.server.SessionManager;

@RequiredArgsConstructor
public class ChangeCommand implements Command {

    private final SessionManager sessionManager;

    @Override
    public void execute(String[] args, Session session) {
        String changeName = args[1];
        sessionManager.sendAll(session.getUsername() + "님이 " + changeName + "로 이름을 변경했습니다.");
        session.setUsername(changeName);
    }
}
