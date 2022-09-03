package co.edu.unbosque.model.persistence;

import com.datastax.oss.driver.api.querybuilder.term.Term;

import java.io.Serializable;

public class Persona implements Serializable {

    private String name;
    private String sex;
    private String phoneNumber;
    private int age;

    public Persona(String name, String sex, String phoneNumber, int age) {
        this.name = name;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
