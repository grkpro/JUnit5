package org.employportal.dto;

import java.util.Date;

public class Employ {
    String id;
    String name;
    double salary;
    int age;
    Date dateOfBirth;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    Date dateOfJoin;
    double bonus;
    Department department;

    @Override
    public String toString() {
        return "Employ{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoin=" + dateOfJoin +
                ", bonus=" + bonus +
                '}';
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Employ(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employ(String id, String name, double salary, Date dateOfBirth, Date dateOfJoin) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoin = dateOfJoin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
