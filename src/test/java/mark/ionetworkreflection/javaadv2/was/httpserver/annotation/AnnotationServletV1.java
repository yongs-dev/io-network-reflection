package mark.ionetworkreflection.javaadv2.was.httpserver.annotation;

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
public class AnnotationServletV1 implements HttpServlet {

    private final List<Object> controllers;

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Mapping.class)) {
                    Mapping mapping = method.getAnnotation(Mapping.class);
                    String value = mapping.value();
                    if (value.equals(path)) {
                        invoke(controller, method, request, response);
                        return;
                    }
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
