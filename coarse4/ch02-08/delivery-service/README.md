## 🚀 스웨거(Swagger)
- 스웨거는 API 문서화, 디자인, 빌드, 테스트 및 사용을 위한 오픈 소스 소프트웨어 프레임워크
- 스웨거는 RESTful API 서비스를 개발하고 문서화하는데 도움을 주는 도구 모음

### ✅ 특징
1. API 문서화 : 스웨거는 API 의 자동화된 문서를 생성하고 표시할 수 있다. 이를 통해 API 엔드포인트, 요청 및 응답 형식, 매개변수, 인증 등을 포함한 API 의 세부 정보를 시각적으로 제공한다.
2. 인터렉티브한 API UI : 스웨거 UI를 통해 API 를 테스트하고 상호작용할 수 있다. 개발자는 스웨거 UI 를 통해 API 엔드포인트를 호출하고 요청을 보내며, 실시간으로 응답을 확인할 수 있다.
3. 코드 생성 : 스웨거는 API 를 기반으로 클라이언트 라이브러리 및 서버 스텁 코드를 자동으로 생성할 수 있다. 이를 통해 클라이언트 어플리케이션과 서버 사이의 통신을 간소화하고 개발 생산성을 향상시킬 수 있다.
4. API 테스트 : 스웨거는 개발자가 API 를 테스트하고 디버깅하는 데 도움을 준다. 스웨거 UI를 사용하여 다양한 요청을 보내고 응답을 확인할 수 있으며, 각 엔드포인트에 대한 예상 동작을 문서화하여 테스트 케이스를 작성할 수도 있다.

### 💥 Spring 3.X.X 버전 기준의 스웨거 의존성 추가
```
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2'
```

### 💥 스웨거 접속 링크

[localhost:8080/swagger-ui/index.html](localhost:8080/swagger-ui/index.html)


## 🚀 Rabbit MQ

- RabbitMQ는 오픈소스 메시지 브로커 소프트웨어이다.

1. 메시지 브로커는 송신자와 수신자 간의 효율적인 메시지 전달을 중개하는 역할을 담당한다.
2. RabbitMQ는 AMQP(Advanced Message Queuing Protocol)를 기반으로 작동하며, 대규모 분산 시스템에서 사용되는 메시지 큐 서비스를 제공한다.
3. RabbitMQ는 프로듀서(메시지를 생성한느 어플리케이션)와 컨슈머(메시지를 소비하는 어플리케이션) 간의 비동기적인 통신을 용이하게 한다.
4. 프로듀서는 메시지를 RabbitMQ에 보내고, RabbitMQ는 이를 큐에 저장한다. 그런 다음 컨슈머는 큐에서 메시지를 가져와 처리할 수 있다.

- RabbitMQ는 여러 어플리케이션 간의 통신을 향상시키고, 비동기 처리를 지원하여 시스템의 확장성과 유연성을 높인다. 또한, RabbitMQ는 다양한 기능을 제공하여 메시지 라우팅, 메시지 필터링, 우선순위 지정 등의 작업을 수행할 수 있다.
- RabbitMQ는 많은 프로그래밍 언어와 통합이 가능하며, 다양한 플랫폼에서 사용할 수 있다. 이를 통해 분산 시스템, 마이크로서비스 아키텍처, 이벤트 기반 시스템 등에서 메시지 기반 통신을 구현할 수 있다.

### ✅ RabbitMQ 실행
- docker 실행하기
- 먼저 docker-compose.yaml 파일이 있는 디렉터리로 이동하기
- 이후 다음의 명령어 실행
```
    docker compose up -d
```
- docker에서 rabbit mq 실행 확인 후, 터미널로 들어가기
```
    rabbitmq-plugins enable rabbitmq_management
```
- [http://localhost:15672/](http://localhost:15672/) 링크로 접속하면 관리자 페이지로 접속 가능하다.
- `docker-compose.yaml`에서 설정한 사용자 정보로 어드민에 접속 가능하다.