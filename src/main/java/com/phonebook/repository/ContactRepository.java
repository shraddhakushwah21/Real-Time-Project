package com.phonebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.phonebook.entity.ContactEntity;

public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {
	
	public List<ContactEntity> findByActiveStatus(Character activeStatus);
	
	@Modifying
	@Transactional
	@Query(value = "update ContactEntity set activeStatus=:activeStatus where contactId=:id")
	public void deleteContact(Character activeStatus,Integer id);
}
