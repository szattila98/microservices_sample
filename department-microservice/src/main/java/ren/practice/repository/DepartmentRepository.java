package ren.practice.repository;

import org.springframework.stereotype.Repository;
import ren.practice.model.Department;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.add(new Department(1L, "Development"));
        this.add(new Department(1L, "Operations"));
        this.add(new Department(2L, "Development"));
        this.add(new Department(2L, "Operations"));
    }

    public Department add(Department department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        Optional<Department> department = departments.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (department.isPresent())
            return department.get();
        else
            return null;
    }

    public List<Department> findAll() {
        return departments;
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departments.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

}
