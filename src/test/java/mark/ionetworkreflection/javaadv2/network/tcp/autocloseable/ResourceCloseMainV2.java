package mark.ionetworkreflection.javaadv2.network.tcp.autocloseable;

/**
 * 핵심 예외가 부가 예외로 바뀌는 문제 발생(CallException -> CloseException)
 */
public class ResourceCloseMainV2 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
             resource1 = new ResourceV1("resource1");
             resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx(); // CallException 발생

            System.out.println("자원 정리"); // 호출 안 됨
            resource2.closeEx();
            resource1.closeEx();
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            if (resource2 != null) {
                resource2.closeEx(); // CloseException 발생
            }

            if (resource1 != null) {
                resource1.closeEx(); // 호출 안 됨
            }
        }
    }
}
