FROM amazoncorretto:20
MAINTAINER gonzalodiaz
COPY portfolioBack/target/portfolioBack-0.0.1-SNAPSHOT.jar portfolioBack-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/portfolioBack-0.0.1-SNAPSHOT.jar"]