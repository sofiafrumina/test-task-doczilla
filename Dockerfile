LABEL authors="sofia"

# Используем образ OpenJDK
FROM openjdk:11-jre-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем .jar файл в контейнер
COPY target/studentApp.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]