import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import servlet.StudentServlet;

import java.io.*;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        // Создаем HTTP-сервер на порту 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Добавляем обработчик для "/students"
        server.createContext("/students", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                HttpExchangeWrapper requestWrapper = new HttpExchangeWrapper(exchange);
                StudentServlet studentServlet = new StudentServlet();

                // Обработка GET запроса
                if ("GET".equalsIgnoreCase(requestWrapper.getMethod())) {
                    studentServlet.doGet(requestWrapper, new HttpExchangeWrapper(exchange));
                }
                // Обработка POST запроса
                else if ("POST".equalsIgnoreCase(requestWrapper.getMethod())) {
                    String requestBody = readRequestBody(exchange.getRequestBody());
                    studentServlet.doPost(requestWrapper, new HttpExchangeWrapper(exchange), requestBody);
                }
                // Обработка других методов, если необходимо
                else {
                    String response = "Method Not Allowed";
                    sendResponse(exchange, response, 405);
                }
            }
        });

        // Запускаем сервер
        server.start();
        System.out.println("Сервер запущен на порту: 8080");
    }

    // Метод для отправки ответа
    private static void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    // Метод для чтения тела запроса
    private static String readRequestBody(InputStream inputStream) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        return requestBody.toString();
    }
}
