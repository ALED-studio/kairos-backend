# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.4/maven-plugin/build-image.html)
* [WebSocket](https://docs.spring.io/spring-boot/4.0.4/reference/messaging/websockets.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.4/reference/web/servlet.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.4/reference/using/devtools.html)
* [Docker Compose Support](https://docs.spring.io/spring-boot/4.0.4/reference/features/dev-services.html#features.dev-services.docker-compose)
* [Spring Modulith](https://docs.spring.io/spring-modulith/reference/)
* [HTTP Client](https://docs.spring.io/spring-boot/4.0.4/reference/io/rest-client.html#io.rest-client.restclient)
* [Spring Session for JDBC](https://docs.spring.io/spring-session/reference/)
* [SpringDoc OpenAPI](https://springdoc.org/)
* [Spring Security](https://docs.spring.io/spring-boot/4.0.4/reference/web/spring-security.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.4/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Flyway Migration](https://docs.spring.io/spring-boot/4.0.4/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/4.0.4/reference/messaging/amqp.html)
* [Java Mail Sender](https://docs.spring.io/spring-boot/4.0.4/reference/io/email.html)
* [Sentry](https://docs.sentry.io/platforms/java/)

### Guides
The following guides illustrate how to use some features concretely:

* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [SpringDoc OpenAPI](https://github.com/springdoc/springdoc-openapi-demos/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Getting Started with Sentry](https://docs.sentry.io/platforms/java/guides/spring-boot/)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)
* rabbitmq: [`rabbitmq:latest`](https://hub.docker.com/_/rabbitmq)

Please review the tags of the used images and set them to the same as you're running in production.

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

