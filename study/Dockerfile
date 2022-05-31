FROM openjdk:11-jre-slim
WORKDIR application

ARG buildDir=build/unpack

COPY ${buildDir}/BOOT-INF/classes/ app
COPY ${buildDir}/BOOT-INF/lib/ lib

CMD ["java", "-cp", "app:lib/*", "com.docker.study.StudyApplication"]