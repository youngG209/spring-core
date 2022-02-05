package hello.core.singleton;

public class SingletonService {

//    싱글톤 패턴 문제점
//    - 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
//    - 의존관계상 클라이언트가 구체 클래스에 의존한다. DIP를 위반한다.
//    - 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
//    - 테스트하기 어렵다.
//    - 내부 속성을 변경하거나 초기화 하기 어렵다.
//    - private 생성자로 자식 클래스를 만들기 어렵다.
//    - 결론적으로 유연성이 떨어진다.
//    - 안티패턴으로 불리기도 한다.

    private static final SingletonService INSTANCE = new SingletonService();

    public static SingletonService getInstance() {
        return INSTANCE;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글돈 객체 로직 호출");
    }
}
