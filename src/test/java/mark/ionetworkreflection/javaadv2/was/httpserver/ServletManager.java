package mark.ionetworkreflection.javaadv2.was.httpserver;

import lombok.Setter;
import mark.ionetworkreflection.javaadv2.was.httpserver.servlet.InternalErrorServlet;
import mark.ionetworkreflection.javaadv2.was.httpserver.servlet.NotFoundErrorServlet;
import mark.ionetworkreflection.javaadv2.was.httpserver.servlet.PageNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletManager {

    private final Map<String, HttpServlet> servletMap = new HashMap<>();
    @Setter
    private HttpServlet defaultServlet;
    @Setter
    private HttpServlet notFoundErrorServlet = new NotFoundErrorServlet();
    @Setter
    private HttpServlet internalErrorServlet = new InternalErrorServlet();

    public ServletManager() {}

    public void add(String path, HttpServlet servlet) {
        servletMap.put(path, servlet);
    }

    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        try {
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(), defaultServlet);

            if (servlet == null) {
                throw new PageNotFoundException("request url= " + request.getPath());
            }

            servlet.service(request, response);
        } catch (PageNotFoundException e) {
            e.printStackTrace();
            notFoundErrorServlet.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            internalErrorServlet.service(request, response);
        }
    }
}
