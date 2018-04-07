package com.mindex.challenge.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindex.challenge.data.Compensation;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String>{
	
	@Query("{'employee.employeeId':?0}")
	List<Compensation> findById(String id);
}
