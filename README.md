### 2. 서버가 시작하는 시점에 부모 ApplicationContext와 자식 ApplicationContext가 초기화되는 과정에 대해 구체적으로 설명해라.
* 설정파일을 로드하며 디펜던시 유효성 확인 및 구조 생성 -> ContextLoader에서 부모 컨텍스트 생성 (빈, 서비스, 다오등 서버의 하위 계층) -> 부모 컨텍스트 디펜던시 인젝션 -> Dispacher init에서 자식 컨텍스트 생성 (컨트롤러 등 서버의 상위 계층) 생성시 부모 컨텍스트 참조

### 3. 서버 시작 후 http://localhost:8080으로 접근해서 질문 목록이 보이기까지 흐름에 대해 최대한 구체적으로 설명하라. 
* REQUEST SEND -> TOMCAT에서 디스패처 서블릿을 찾음 -> 디스패처에서 인터셉터 프리핸들 -> 디스패처에서 매핑된 메서드 호출 -> 메서드에서 DB접근 -> MAV에 데이터 뿌림 -> MAV리턴 -> MAV렌더링 -> 인터셉터 포스트핸들


### 9. UserService와 QnaService 중 multi thread에서 문제가 발생할 가능성이 있는 소스는 무엇이며, 그 이유는 무엇인가?
* UserService이다. Default = singlton이므로, UserServices는 하나의 인스턴스를 멀티스레드가 공유한다. 그 결과 다양한 유저가 하나의 상태값을 사용할 수 있으며, 충돌이 발생할 수 있다. Prototype 스코프를 사용하면 GetBean시 마다 인스턴스를 새로 생성해 할당하므로, 문제를 막을 수 있다.