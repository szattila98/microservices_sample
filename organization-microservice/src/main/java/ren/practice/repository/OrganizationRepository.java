package ren.practice.repository;

import org.springframework.stereotype.Repository;
import ren.practice.model.Organization;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrganizationRepository {

    private List<Organization> organizations = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.add(new Organization("Microsoft", "Redmond, Washington, USA"));
        this.add(new Organization("Oracle", "Redwood City, California, USA"));
    }

    public Organization add(Organization organization) {
        organization.setId((long) (organizations.size() + 1));
        organizations.add(organization);
        return organization;
    }

    public Organization findById(Long id) {
        Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (organization.isPresent())
            return organization.get();
        else
            return null;
    }

    public List<Organization> findAll() {
        return organizations;
    }

}