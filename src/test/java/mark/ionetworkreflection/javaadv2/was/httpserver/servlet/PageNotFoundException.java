package mark.ionetworkreflection.javaadv2.was.httpserver.servlet;

public class PageNotFoundException extends RuntimeException {

    public PageNotFoundException(String message) {
        super(message);
    }
}
