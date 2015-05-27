### 2. 서버가 시작하는 시점에 부모 ApplicationContext와 자식 ApplicationContext가 초기화되는 과정에 대해 구체적으로 설명해라.
* 



### 3. 서버 시작 후 http://localhost:8080으로 접근해서 질문 목록이 보이기까지 흐름에 대해 최대한 구체적으로 설명하라. 
* 


### 9. UserService와 QnaService 중 multi thread에서 문제가 발생할 가능성이 있는 소스는 무엇이며, 그 이유는 무엇인가?
* Default = singlton이므로, UserServices는 하나의 인스턴스를 멀티스레드가 공유한다. 그 결과 다양한 유저가 하나의 상태값을 사용할 수 있으며, 충돌이 발생할 수 있다. Prototype 스코프를 사용하면 GetBean시 마다 인스턴스를 새로 생성해 할당한다.