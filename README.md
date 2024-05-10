jpa 연습용

이번에 알게 된 것들 :

# EntityManager

JPA에서 CRUD 중 UPDATE는 존재하지 않는다. 그래도 업데이트 동작을 수행함.
영속성 컨텍스트가 데이터의 변경을 감지해 자동으로 update 쿼리를 수행하기 떄문이다.

JPA는 EntityManager와 영속성 컨텍스트를 통해 변화를 감지하고 필요한 쿼리를 자동으로 수행한다.

Application이 시작될 때 EntityManager를 자동으로 bean에 등록한다.

EntityManager를 생성할 땐 팩토리를 사용하는 것이 좋다.
EntityManagerFactory는 Thread safe 처리가 되어 있지만, EntityManager는 아니기 때문에 스레드 공유에 주의해야함.
