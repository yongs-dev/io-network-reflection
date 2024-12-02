package mark.ionetworkreflection.javaadv2.network.tcp.autocloseable;

/**
 * try-with-resources 사용
 * <ul>
 *     <li>리소스 누수 방지</li>
 *         모든 리소스가 제대로 닫히도록 보장한다.
 *     <li>코드 간결성 및 가독성 향상</li>
 *         명시적인 close() 호출이 필요 없다.
 *     <li>스코프 범위 한정</li>
 *         리소스로 사용되는 resource1, 2 변수의 스코프가 try 블럭 안으로 한정된다.
 *     <li>조금 더 빠른 자원 해제</li>
 *         기존에는 try -> catch -> finally로 catch 이후에 자원을 반납했지만 try-with-resources는 try 블럭이 끝나면 즉시 close()를 호출한다.
 *     <li>자원 정리 순서</li>
 *         먼저 선언한 자원을 나중에 정리한다.
 *     <li>부가 예외 포함</li>
 *         try-with-resources 핵심 예외를 반환한다.<br>
 *         부가 예외는 핵심 예외안에 Suppressed로 담아서 반환한다.<br>
 *         개발자는 자원 정리 중에 발생한 부가 예외를 e.getSuppressed()를 통해 활용할 수 있다.
 * </ul>
 */
public class ResourceCloseMainV4 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");

            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("throwable: " + throwable);
            }

            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        try (ResourceV2 resource1 = new ResourceV2("resource1");
             ResourceV2 resource2 = new ResourceV2("resource2")) {

            resource1.call();
            resource2.callEx(); // CallException 발생
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }
    }
}
