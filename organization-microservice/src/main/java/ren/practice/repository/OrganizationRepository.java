package ren.practice.repository;

import org.springframework.data.repository.CrudRepository;
import ren.practice.model.Organization;

import java.util.Optional;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    @Override
    <S extends Organization> S save(S s);

    @Override
    Optional<Organization> findById(Long aLong);

    @Override
    Iterable<Organization> findAll();
}
