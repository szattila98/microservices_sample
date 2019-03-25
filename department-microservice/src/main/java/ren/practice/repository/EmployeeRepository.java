package ren.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ren.practice.model.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    <S extends Employee> S save(S s);

    @Override
    Optional<Employee> findById(Long aLong);

    @Override
    Iterable<Employee> findAll();
}
