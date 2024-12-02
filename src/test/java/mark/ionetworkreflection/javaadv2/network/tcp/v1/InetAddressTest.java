package mark.ionetworkreflection.javaadv2.network.tcp.v1;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static mark.ionetworkreflection.javaadv2.util.MyLogger.log;

public class InetAddressTest {

    @Test
    void inetAddressTest() throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        log(localhost);

        InetAddress google = InetAddress.getByName("google.com");
        log(google);
    }
}
