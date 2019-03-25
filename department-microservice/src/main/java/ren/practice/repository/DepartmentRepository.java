package ren.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ren.practice.model.Department;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    @Override
    <S extends Department> S save(S s);

    @Override
    Optional<Department> findById(Long aLong);

    @Override
    Iterable<Department> findAll();
}
