package mark.ionetworkreflection.javaadv2.network.tcp.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Shutdown-Hook</b><br>
 * 동시성 처리 필요. 서버 종료시 or 세션 종료시 자원 해제
 */
public class SessionManagerV6 {

    private final List<SessionV6> sessions = new ArrayList<>();

    public synchronized void add(SessionV6 session) {
        sessions.add(session);
    }

    public synchronized void remove(SessionV6 session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (SessionV6 session : sessions) {
            session.close();
        }

        sessions.clear();
    }
}
