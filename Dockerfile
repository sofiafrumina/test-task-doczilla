# Используем образ OpenJDK для запуска Java-приложений
FROM openjdk:11-jre-slim

# Указываем автора образа
LABEL authors="sofia"

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный jar-файл приложения в контейнер
COPY target/StudentsApp-0.0.1-SNAPSHOT.jar /app/StudentsApp.jar

# Открываем порт, который будет использоваться приложением
EXPOSE 8080

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "StudentsApp.jar"]
