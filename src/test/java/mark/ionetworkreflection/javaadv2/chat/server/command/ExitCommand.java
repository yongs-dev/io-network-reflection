package mark.ionetworkreflection.javaadv2.chat.server.command;

import lombok.RequiredArgsConstructor;
import mark.ionetworkreflection.javaadv2.chat.server.Session;

import java.io.IOException;

@RequiredArgsConstructor
public class ExitCommand implements Command {

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("Exit");
    }
}
