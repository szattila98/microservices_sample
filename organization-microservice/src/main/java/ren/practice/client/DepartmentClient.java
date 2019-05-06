package ren.practice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ren.practice.model.Department;

import java.util.List;

/**
 * With this interface organization service can request data from a department service endpoint.
 * OpenFeign generates a class for it based on this interface, much like a JPA would.
 *
 * @author Attila Szőke
 */
@FeignClient(name = "department-service")
public interface DepartmentClient {

    /**
     * Find by organization list.
     *
     * @param organizationId the organization id
     * @return the list
     */
    @GetMapping("/organization/{organizationId}")
    List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId);

    /**
     * Find by organization with employees list.
     *
     * @param organizationId the organization id
     * @return the list
     */
    @GetMapping("/organization/{organizationId}/with-employees")
    List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);
}
