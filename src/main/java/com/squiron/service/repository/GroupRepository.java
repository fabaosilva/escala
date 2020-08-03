package com.squiron.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.squiron.service.pojo.Group;

@RepositoryRestResource(path = "groups")
public interface GroupRepository extends CrudRepository<Group, Long>{

}
