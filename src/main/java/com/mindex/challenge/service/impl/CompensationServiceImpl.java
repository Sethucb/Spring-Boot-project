package com.mindex.challenge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService{	
	
	private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);
	
	@Autowired
	private CompensationRepository compensationRepository;
	
	@Override	
	public Compensation read(String id) {
		LOG.debug("Compensation read for employee id [{}]", id);
		List<Compensation> list = compensationRepository.findById(id);
		if(list == null || list.size() == 0) {
			throw new RuntimeException("Invlid employee id "+id);
		}
		return list.get(0);
	}
	
	@Override
	public Compensation create(Compensation compensation) {
		LOG.debug("Creating compensation [{}]", compensation);
		return compensationRepository.save(compensation);
	}

}
