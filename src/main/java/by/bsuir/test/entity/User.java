package by.bsuir.test.entity;


import java.util.ArrayList;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private ArrayList<Role> role;
    private ArrayList<String> mobilePhone;

    public User(int id, String name, String surname,
                String email, ArrayList<Role> role, ArrayList<String> mobilePhone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.mobilePhone = mobilePhone;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Role> getRole() {
        return role;
    }

    public void setRole(ArrayList<Role> role) {
        this.role = role;
    }

    public ArrayList<String> getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(ArrayList<String> mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getRole(), user.getRole()) && Objects.equals(getMobilePhone(), user.getMobilePhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getEmail(), getRole(), getMobilePhone());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", mobilePhone=" + mobilePhone +
                '}';
    }
}


