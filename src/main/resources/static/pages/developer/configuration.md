## 3.1 Configuration

EMS 시스템은 다양한 설정 파일을 통해 구성됩니다. 아래는 주요 설정 파일과 그 역할에 대한 설명입니다.

### 3.1.1 `web.xml`
- **설명:** `web.xml` 파일은 Java 웹 애플리케이션의 배포 설명자로, 서블릿, 필터, 리스너 등 웹 애플리케이션의 전반적인 구성을 정의합니다. 이 파일은 웹 애플리케이션의 진입점을 설정하고 보안, 세션 관리 등을 제어합니다.

### 3.1.2 `context.xml`
- **설명:** `context.xml` 파일은 서버의 컨텍스트 구성 파일로, 데이터베이스 연결 설정이나 자원 관리, JNDI 설정 등을 정의합니다. 애플리케이션이 서버와 상호작용하는 환경을 설정하는 중요한 파일입니다.

### 3.1.3 `applicationContext.xml`
- **설명:** Spring 프레임워크의 루트 컨텍스트 구성 파일입니다. 서비스, 리포지토리, 컴포넌트 등 애플리케이션의 전반적인 빈(Bean) 설정을 정의하고 Spring DI(Dependency Injection)를 관리합니다.

### 3.1.4 `applicationContext-datasource-xxx.xml`
- **설명:** 데이터 소스 관련 설정 파일입니다. 데이터베이스 연결 풀과 관련된 설정을 포함하며, 여러 환경별 데이터베이스 연결 정보를 별도로 관리합니다.

### 3.1.5 `applicationContext-jdbc-xxx.xml`
- **설명:** JDBC 설정을 담당하는 파일로, JDBC 연결 설정 및 트랜잭션 관리와 관련된 빈들을 정의합니다. `DataSource` 빈과 관련된 설정이 이곳에 포함됩니다.

### 3.1.6 `applicationContext-jpa.xml`
- **설명:** JPA (Java Persistence API) 설정 파일입니다. 엔티티 매니저 팩토리, 트랜잭션 매니저, JPA 관련 프로퍼티 설정 등을 정의하여 데이터베이스와의 ORM 매핑을 지원합니다.

### 3.1.7 `applicationContext-schedule.xml`
- **설명:** 스케줄링과 관련된 설정을 관리하는 파일입니다. Quartz와 같은 스케줄러를 설정하고, 각 배치 작업이나 정기적으로 실행될 작업에 대한 스케줄을 정의합니다.

### 3.1.8 `applicationContext-udpip.xml`
- **설명:** UDP 및 IP 관련 통신 설정을 담당하는 파일입니다. 네트워크 통신을 처리하는 설정 및 포트와 연결된 서비스의 구성이 포함됩니다.

### 3.1.9 `springapp-servlet.xml`
- **설명:** Spring MVC 서블릿 설정 파일입니다. 요청을 처리할 컨트롤러와 뷰 리졸버, 핸들러 맵핑 등의 설정이 포함되어 있으며, 웹 애플리케이션의 서블릿 컨텍스트를 정의합니다.

---

