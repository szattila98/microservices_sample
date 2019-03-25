package ren.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ren.practice.model.Department;
import ren.practice.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private DepartmentRepository repository;

    @Autowired
    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return repository.save(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        LOGGER.info("Department find: id={}", id);
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else return new Department(null, "error");
    }

    @GetMapping("/")
    public List<Department> findAll() {
        LOGGER.info("Department find");
        ArrayList<Department> departments = new ArrayList<>();
        repository.findAll().forEach(a -> departments.add(a));
        return departments;
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        ArrayList<Department> departments = new ArrayList<>();
        repository.findAll().forEach(a -> departments.add(a));
        return departments.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

//    @GetMapping("/organization/{organizationId}/with-employees")
//    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
//        LOGGER.info("Department find: organizationId={}", organizationId);
//        List<Department> departments = repository.findByOrganization(organizationId);
//        departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
//        return departments;
//    }
}
