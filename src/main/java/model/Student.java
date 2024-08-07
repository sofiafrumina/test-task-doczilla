package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthdate;
    private String groupName;
    private Integer uniqueNumber;

    // Getter для id
    public Long getId() {
        return id;
    }

    // Setter для id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter для name
    public String getName() {
        return name;
    }

    // Setter для name
    public void setName(String name) {
        this.name = name;
    }

    // Getter для surname
    public String getSurname() {
        return surname;
    }

    // Setter для surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter для patronymic
    public String getPatronymic() {
        return patronymic;
    }

    // Setter для patronymic
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    // Getter для birthdate
    public LocalDate getBirthdate() {
        return birthdate;
    }

    // Setter для birthdate
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    // Getter для groupName
    public String getGroupName() {
        return groupName;
    }

    // Setter для groupName
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    // Getter для uniqueNumber
    public Integer getUniqueNumber() {
        return uniqueNumber;
    }

    // Setter для uniqueNumber
    public void setUniqueNumber(Integer uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }
}
