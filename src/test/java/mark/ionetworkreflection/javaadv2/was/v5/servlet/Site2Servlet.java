package mark.ionetworkreflection.javaadv2.was.v5.servlet;

import mark.ionetworkreflection.javaadv2.was.httpserver.HttpRequest;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpResponse;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpServlet;

public class Site2Servlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }
}
