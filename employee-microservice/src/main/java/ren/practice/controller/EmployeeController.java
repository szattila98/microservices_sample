package ren.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ren.practice.model.Employee;
import ren.practice.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the controller of the Employee microservice.
 */
@RestController
@RequestMapping("/service")
class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeRepository repository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else return new Employee(null,null,"error",1,"error");
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Employee find");
        List<Employee> employees = new ArrayList<>();
        repository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    @GetMapping("/department/{departmentId}")
    public List findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        List<Employee> employees = new ArrayList<>();
        repository.findAll().forEach(employee -> employees.add(employee));
        return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
    }

    @GetMapping("/organization/{organizationId}")
    public List findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Employee find: organizationId={}", organizationId);
        List<Employee> employees = new ArrayList<>();;
        repository.findAll().forEach(employee -> employees.add(employee));
        return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

}
