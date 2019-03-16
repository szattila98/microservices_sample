package ren.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ren.practice.model.Employee;

import java.util.List;

/**
 * This is the repository for employees.
 * It configured to connect to a MariaDb database.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    @NonNull
    <S extends Employee> S save(@NonNull S s);

    @Override
    @NonNull
    Employee getOne(@NonNull Long aLong);

    @Override
    @NonNull
    List<Employee> findAll();
}
