package ren.practice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ren.practice.model.Employee;

import java.util.List;

/**
 * With this interface organization service can request data from an employee service endpoint.
 * OpenFeign generates a class for it based on this interface, much like a JPA would.
 *
 * @author Attila Szőke
 */
@FeignClient(name = "employee-service")
public interface EmployeeClient {

    /**
     * Find by organization list.
     *
     * @param organizationId the organization id
     * @return the list
     */
    @GetMapping("/organization/{organizationId}")
    List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId);

}
