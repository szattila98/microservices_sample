package ren.practice.model;

/**
 * Model class for employees, feign uses it
 *
 * @author Szőke Attila
 */
public class Employee {

    private Long id;
    private String name;
    private int age;
    private String position;

    /**
     * Instantiates a new Employee.
     */
    public Employee() {

    }

    /**
     * Instantiates a new Employee.
     *
     * @param name     the name
     * @param age      the age
     * @param position the position
     */
    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
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
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", position=" + position + "]";
    }

}