import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import servlet.StudentServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        // Создаем сервер на порту 8080
        Server server = new Server(8080);

        // Контекст для сервлетов
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // Регистрируем сервлет
        server.setHandler(context);
        context.addServlet(StudentServlet.class, "/students");

        // Запуск сервера
        server.start();
        server.join();
    }
}
