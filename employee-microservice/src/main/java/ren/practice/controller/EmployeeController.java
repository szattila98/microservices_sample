package ren.practice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ren.practice.model.Employee;
import ren.practice.repository.EmployeeRepository;

/**
 * Controller of the employee service with some simple endpoints.
 *
 * @author Attila Szőke
 */
@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeRepository repository;

    /**
     * Instantiates a new Employee controller.
     *
     * @param repository the repository
     */
    @Autowired
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    /**
     * Add an employee.
     *
     * @param employee the employee
     * @return the employee
     */
    @PostMapping("/")
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return repository.add(employee);
    }

    /**
     * Find employee by employee id.
     *
     * @param id the id
     * @return the employee
     */
    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    /**
     * Find all employees.
     *
     * @return the list
     */
    @GetMapping("/")
    public List<Employee> findAll() {
        LOGGER.info("Employee find");
        return repository.findAll();
    }

    /**
     * Find employees by department.
     *
     * @param departmentId the department id
     * @return the list
     */
    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }

    /**
     * Find employees by organization.
     *
     * @param organizationId the organization id
     * @return the list
     */
    @GetMapping("/organization/{organizationId}")
    public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Employee find: organizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }

}
