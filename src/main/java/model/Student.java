package model;

public class Student {
    private int id;               // Уникальный номер студента
    private String firstName;      // Имя
    private String lastName;       // Фамилия
    private String patronymic;     // Отчество
    private String group;          // Группа
    private String birthDate;      // Дата рождения

    // Конструктор без параметров (для создания пустых объектов)
    public Student() {}

    // Конструктор с параметрами (для создания объекта студента)
    public Student(int id, String firstName, String lastName, String patronymic, String group, String birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.group = group;
        this.birthDate = birthDate;
    }

    // Геттеры и сеттеры для каждого поля
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
