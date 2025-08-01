# 멀티 스테이지 빌드 (빌드 + 실행 분리)
FROM openjdk:17-jdk-slim as builder

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 설정 파일들 복사
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradle/ gradle/
COPY gradlew .

# 의존성 다운로드 (캐시 최적화)
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

# 소스 코드 복사 및 빌드
COPY src/ src/
RUN ./gradlew bootJar --no-daemon

# 실행 단계
FROM openjdk:17-jdk-slim

WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 로그 디렉토리 생성
RUN mkdir -p /app/logs

# 포트 노출
EXPOSE 8081

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]