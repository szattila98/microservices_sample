package ren.practice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ren.practice.model.Employee;

import java.util.List;

/**
 * With this interface department service can request data from an employee service endpoint.
 * OpenFeign generates a class for it based on this interface, much like a JPA would.
 *
 * @author Attila Szőke
 */
@FeignClient(name = "employee-service")
public interface EmployeeClient {

    /**
     * Lists employees by departmentId.
     *
     * @param departmentId Id of a department to filter employees
     * @return List of employees
     */
    @GetMapping("/department/{departmentId}")
    List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
