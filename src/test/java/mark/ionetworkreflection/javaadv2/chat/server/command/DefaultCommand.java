package mark.ionetworkreflection.javaadv2.chat.server.command;

import lombok.RequiredArgsConstructor;
import mark.ionetworkreflection.javaadv2.chat.server.Session;

import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
public class DefaultCommand implements Command {

    @Override
    public void execute(String[] args, Session session) throws IOException {
        session.send("처리할 수 없는 명령어 입니다: " + Arrays.asList(args));
    }
}
