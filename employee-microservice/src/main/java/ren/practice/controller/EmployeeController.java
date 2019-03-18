package ren.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ren.practice.model.Employee;
import ren.practice.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the controller of the Employee microservice.
 */
@RestController
class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeRepository repository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    @PostMapping
    public Employee add(Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.getOne(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Employee find");
        return repository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return repository.findAll().stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
    }

    @GetMapping("/organization/{organizationId}")
    public List findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Employee find: organizationId={}", organizationId);
        return repository.findAll().stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

}
