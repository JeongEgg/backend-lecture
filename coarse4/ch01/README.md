## 🚀 웹 인증
- 웹 인증(Web Authentication)이란 웹 어플리케이션에서 사용자의 정체성을 확인하고 적절한 권한을 부여하는 과정이다. 웹 인증은 사용자가 누구인지 확인하고, 해당 사용자가 액세스하려는 웹 리소스나 서비스에 대한 권한이 있는지 확인하는 데 사용된다.

- 웹 인증은 웹 서비스의 보안성을 높이며, 사용자 데이터의 무단 접근을 방지하기 위한 중요한 보안 요소이다.


### ✅ 로그인 인증

1. ID/PW 기반 로그인
2. 소셜 로그인(Oauth2)
3. 이메일 인증
4. 휴대폰 인증
5. 다중 인증요소(MFA)

---

## 🚀 HTTP SESSION

- HTTP SESSION 은 웹 어플리케이션에서 사용자 정보를 저장하는 기술이다. 사용자의 세션은 웹 어플리케이션에 접속한 후, 일정 시간동안  유지되는 정보

### ✅ 특징
1. HTTP 프로토콜은 Stateless 한 특성을 가지기 때문에 사용자가 다시 요청을 보낼 때마다 사용자 정보를 매번 다시 전송해야 한다. HTTP Session 은 이러한 문제를 해결하기 위해 사용자 정보를 서버측에서 저장하고 관리하는 세션 ID를 발급한다.
2. HTTP Session 은 쿠키(Cookie)를 사용하여 구현된다.
3. HTTP Session 은 사용자 로그인 정보를 관리할 때 사용하며, 사용자가 다시 접속하여도 유지된다.
4. HTTP Session 은 서버에서 관리되기 때문에 사용자가 임의로 세션 정보를 조작할 수 없다. 해당 값은 랜덤한 값으로 생성되며, HTTPS를 통해서 암호화된다.

### ✅ 인증 과정
1. 사용자가 로그인을 시도
2. 서버는 사용자의 인증 정보를 검증하여 session id를 생성
3. 세션은 서버측에서 관리되며, 서버에서 갱신 및 정보를 변경할 수 있다.
4. 세션 ID는 쿠키(Cookie) 방식으로 사용자에게 전달되며, 웹 어플리케이션에서 사용된다.
