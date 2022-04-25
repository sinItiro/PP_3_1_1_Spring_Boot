package akademy.kata.springboot.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "name non blank")
    @Size(min = 2, max = 32, message = "min/max length name")
    private String name;

    @NotEmpty(message = "surname non blank")
    @Size(min = 2, max = 32, message = "min/max length surname")
    private String surname;

    @Min(value = 0, message = "age > 0")
    private byte age;

    @NotEmpty(message = "login non blank")
    @Size(min = 2, max = 32, message = "min/max length login")
    private String login;
    private static long indexId=0;

    public User() {

    }

    public User(String name, String surname, byte age, String login) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, login);
    }
}