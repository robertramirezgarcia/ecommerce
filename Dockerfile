FROM openjdk:8-jdk-alpine
ADD "./target/ecommerce-1.0.0.jar" "app.jar"
ENTRYPOINT ["java", "-jar", "app.jar"]