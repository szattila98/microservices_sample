# Microservices practice with Eureka discovery service
An amateur microservice practice with netflixes eureka discovery server

Used tutorials and articles:
  - https://spring.io/guides/gs/centralized-configuration/
  - https://spring.io/blog/2015/01/20/microservice-registration-and-discovery-with-spring-cloud-and-netflix-s-eureka
  - https://spring.io/blog/2015/07/14/microservices-with-spring

For generating javadoc: mvn javadoc:jar <Br>
For swagger-ui in employee serivce: $host:$port/swagger-ui.html <br>
Run projects from terminal with mvn: mvnw -DskipTests spring-boot:run <br>
You can run another instance of a microservice if there is a property yml for it in the config repo <br>
        with: mvnw -DskipTests -Dspring.profiles.active=instanceName spring-boot:run <br>

**If you change packaging to jar from war** <br>
For good packaging: mvn clean install spring-boot:repackage <br>
    - after packaging jars can be independently ran (well at least I hope) <br>
    - run jars with: java -jar yourApplication.jar <br>
    - you can run another instance of a microservice <br>
        if there is a property yml for it in the config repo <br>
        with: java -jar -Dspring.profiles.active=instanceName yourApplication.jar <br>                