package ren.practice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ren.practice.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * This is the repository for employees.
 * It configured to connect to a MariaDb database.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    <S extends Employee> S save(S s);

    @Override
    Optional<Employee> findById(Long aLong);

    @Override
    Iterable<Employee> findAll();
}