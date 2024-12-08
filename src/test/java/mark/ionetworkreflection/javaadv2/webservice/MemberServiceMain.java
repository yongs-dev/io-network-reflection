package mark.ionetworkreflection.javaadv2.webservice;

import mark.ionetworkreflection.javaadv2.io.member.impl.MemoryMemberRepository;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpServer;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpServlet;
import mark.ionetworkreflection.javaadv2.was.httpserver.ServletManager;
import mark.ionetworkreflection.javaadv2.was.httpserver.annotation.AnnotationServletV3;
import mark.ionetworkreflection.javaadv2.was.httpserver.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class MemberServiceMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpServlet servlet = new AnnotationServletV3(List.of(new MemberController(new MemoryMemberRepository())));
        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(servlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
