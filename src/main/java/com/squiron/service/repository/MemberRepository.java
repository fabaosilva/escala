package com.squiron.service.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.squiron.service.pojo.Member;

@RepositoryRestResource(collectionResourceRel = "member", path = "members")
public interface MemberRepository extends PagingAndSortingRepository<Member, Long>{

}
