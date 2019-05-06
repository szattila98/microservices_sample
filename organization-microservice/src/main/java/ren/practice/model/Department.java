package ren.practice.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Department model class for feign client.
 *
 * @author Szőke Attila
 */
public class Department {

    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    /**
     * Instantiates a new Department.
     */
    public Department() {

    }

    /**
     * Instantiates a new Department.
     *
     * @param name the name
     */
    public Department(String name) {
        super();
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets employees.
     *
     * @return the employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sets employees.
     *
     * @param employees the employees
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }

}