package mark.ionetworkreflection.javaadv2.was.v7;

import mark.ionetworkreflection.javaadv2.was.httpserver.HttpServer;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpServlet;
import mark.ionetworkreflection.javaadv2.was.httpserver.ServletManager;
import mark.ionetworkreflection.javaadv2.was.httpserver.annotation.AnnotationServletV1;
import mark.ionetworkreflection.javaadv2.was.httpserver.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class ServerMainV7 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV7(), new SearchControllerV7());
        HttpServlet annotationServlet = new AnnotationServletV1(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}