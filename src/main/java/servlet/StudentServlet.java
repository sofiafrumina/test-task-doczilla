package servlet;

import db.Database;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Получение данных из тела запроса
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String patronymic = request.getParameter("patronymic");
        String birthDate = request.getParameter("birth_date");
        String studentGroup = request.getParameter("group");

        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO students (first_name, last_name, patronymic, birth_date, student_group) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, patronymic);
            statement.setDate(4, Date.valueOf(birthDate));
            statement.setString(5, studentGroup);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println("[");

            while (resultSet.next()) {
                out.println("{");
                out.println("\"id\": \"" + resultSet.getInt("id") + "\",");
                out.println("\"first_name\": \"" + resultSet.getString("first_name") + "\",");
                out.println("\"last_name\": \"" + resultSet.getString("last_name") + "\",");
                out.println("\"patronymic\": \"" + resultSet.getString("patronymic") + "\",");
                out.println("\"birth_date\": \"" + resultSet.getDate("birth_date") + "\",");
                out.println("\"group\": \"" + resultSet.getString("student_group") + "\"");
                out.println("},");
            }

            out.println("]");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        try (Connection connection = Database.getConnection()) {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

