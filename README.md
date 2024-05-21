// error code 규
1. common 에러는 COMMON000 으로 둔다. <- 잘 안쓰지만 마땅하지 않을 때 사용
2. 관련된 경우마다 code에 명시적으로 표현한다.
	- 예를 들어 멤버 관련이면 MEMBER001 이런 식으로
3. 2번에 이어서 4000번대를 붙인다. 서버측 잘못은 그냥 COMMON 에러의 서버 에러를 쓰면 됨.
	- MEMBER400_1 아니면 MEMBER4001 이런 식으로

// service 작성
1. GET 요청과 나머지 요청에 대해 아래와 같이 분리한다.

	a. GET 요청에 대한 비즈니스 로직을 처리할 경우
			TempQueryService 이렇게 만든다.
	b. 나머지 요청에 대한 비즈니스 로직을 처리할 경우
			TempCommandService 이렇게 만든다.

2. 서비스를 만들 경우 인터페이스를 먼저 두고 이를 구체화 한다.
	 TempQueryService 인터페이스, TempCommandService 인터페이스를 만들고,
	 이에 대한 Impl 구체화 클래스를 만든다.

3. 컨트롤러는 인터페이스를 의존하며 실제 인터페이스에 대한 구체화 클래스는
	 Springboot의 의존성 주입을 이용한다!
