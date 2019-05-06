package ren.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ren.practice.client.EmployeeClient;
import ren.practice.model.Department;
import ren.practice.repository.DepartmentRepository;

import java.util.List;


/**
 * Controller of the department service with some simple endpoints.
 *
 * @author Attila Szőke
 */
@RestController
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private DepartmentRepository repository;
    private EmployeeClient employeeClient;

    /**
     * Instantiates a new Department controller.
     *
     * @param repository     the repository
     * @param employeeClient the employee client
     */
    @Autowired
    public DepartmentController(DepartmentRepository repository, EmployeeClient employeeClient) {
        this.repository = repository;
        this.employeeClient = employeeClient;
    }

    /**
     * Add a department.
     *
     * @param department the department
     * @return the department
     */
    @PostMapping("/")
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return repository.add(department);
    }

    /**
     * Find department by department id.
     *
     * @param id the id
     * @return the department
     */
    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        LOGGER.info("Department find: id={}", id);
        return repository.findById(id);
    }

    /**
     * Find all departments.
     *
     * @return the list
     */
    @GetMapping("/")
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return repository.findAll();
    }

    /**
     * Find departments by organization.
     *
     * @param organizationId the organization id
     * @return the list
     */
    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }

    /**
     * Find departments by organization with employees with the help of feign client.
     *
     * @param organizationId the organization id
     * @return the list
     */
    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        List<Department> departments = repository.findByOrganization(organizationId);
        departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
        return departments;
    }

}
