package mark.ionetworkreflection.javaadv2.was.httpserver.reflectionServlet;

import lombok.RequiredArgsConstructor;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpRequest;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpResponse;
import mark.ionetworkreflection.javaadv2.was.httpserver.HttpServlet;
import mark.ionetworkreflection.javaadv2.was.httpserver.servlet.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@RequiredArgsConstructor
public class ReflectionServlet implements HttpServlet {

    private final List<Object> controllers;

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        for (Object controller : controllers) {
            Class<?> aClass = controller.getClass();
            Method[] methods = aClass.getDeclaredMethods();

            for (Method method : methods) {
                if (path.equals("/" + method.getName())) {
                    invoke(controller, method, request, response);
                    return;
                }
            }
        }

        throw new PageNotFoundException("request = " + path);
    }

    private static void invoke(Object controller, Method method, HttpRequest request, HttpResponse response) {
        try {
            method.invoke(controller, request, response);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
