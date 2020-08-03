package com.squiron.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.squiron.service.pojo.Shift;

@RepositoryRestResource(path = "shifts",collectionResourceRel = "relShifts")
public interface ShiftRepository extends CrudRepository<Shift, Long>{
	
	List<Shift> findByName(@Param("name") String name);
	
}
