package ren.practice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    private int age;
    @NotNull
    private String position;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "departments_id")
    private Department department;

    public Employee() {

    }

    public Employee(String name, int age, String position, @NotNull Long departmentId, @NotNull Department department) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.department = department;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", position=" + position + "]";
    }
}
