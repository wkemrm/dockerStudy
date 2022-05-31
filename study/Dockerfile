# FROM openjdk:11-jre-slim
# WORKDIR application
#
# ARG buildDir=build/unpack
# RUN ./gradlew build
# COPY ${buildDir}/BOOT-INF/classes/ app
# COPY ${buildDir}/BOOT-INF/lib/ lib
#
# CMD ["java", "-cp", "app:lib/*", "com.docker.study.StudyApplication"]
#
# FROM openjdk:11-jdk
#
# ARG JAR_FILE=build/libs/*.jar
# COPY ${JAR_FILE} springbootapp.jar
#
# ENTRYPOINT ["java", "-jar", "/springbootapp.jar"]

FROM openjdk:11-jre-slim as builder
WORKDIR application
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:11-jre-slim
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]