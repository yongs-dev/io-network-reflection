package mark.ionetworkreflection.javaadv2.was.httpserver.servlet;

import mark.ionetworkreflection.javaadv2.was.httpserver.HttpRequest;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpResponse;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpServlet;

public class DiscardServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        // empty
    }
}
