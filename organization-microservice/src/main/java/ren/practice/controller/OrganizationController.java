package ren.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ren.practice.model.Organization;
import ren.practice.repository.OrganizationRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service")
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    private OrganizationRepository repository;

    @Autowired
    public OrganizationController(OrganizationRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Organization add(@RequestBody Organization organization) {
        LOGGER.info("Organization add: {}", organization);
        return repository.save(organization);
    }

    @GetMapping
    public List<Organization> findAll() {
        LOGGER.info("Organization find");
        ArrayList<Organization> organizations = new ArrayList<>();
        repository.findAll().forEach(a -> organizations.add(a));
        return organizations;
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else return new Organization(null, "error");
    }

//    @GetMapping("/{id}/with-departments")
//    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
//        LOGGER.info("Organization find: id={}", id);
//        Organization organization = repository.findById(id);
//        organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
//        return organization;
//    }
//
//    @GetMapping("/{id}/with-departments-and-employees")
//    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
//        LOGGER.info("Organization find: id={}", id);
//        Organization organization = repository.findById(id);
//        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
//        return organization;
//    }
//
//    @GetMapping("/{id}/with-employees")
//    public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
//        LOGGER.info("Organization find: id={}", id);
//        Organization organization = repository.findById(id);
//        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
//        return organization;
//    }
}
