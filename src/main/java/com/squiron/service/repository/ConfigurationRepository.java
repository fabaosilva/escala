package com.squiron.service.repository;

import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.squiron.service.pojo.ConfigurationScale;
import com.squiron.service.pojo.Group;

@Repository
public interface ConfigurationRepository extends PagingAndSortingRepository<ConfigurationScale,Long>{

	ArrayList<ConfigurationScale> findByGroup(Group group);

}
