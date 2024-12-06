package mark.ionetworkreflection.javaadv2.chat.server.command;

import mark.ionetworkreflection.javaadv2.chat.server.Session;

import java.io.IOException;

public interface Command {

    void execute(String[] args, Session session) throws IOException;
}
