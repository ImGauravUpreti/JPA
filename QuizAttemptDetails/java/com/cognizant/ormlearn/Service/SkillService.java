package com.cognizant.ormlearn.Service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.OrmLearnRelationshipsApplication;
import com.cognizant.ormlearn.Repository.SkillRepository;
import com.cognizant.ormlearn.model.Skill;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepository;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnRelationshipsApplication.class);
    @Transactional
	public Skill get(int id)
	{
		LOGGER.info("Start"); 
		return skillRepository.findById(id).get();	
	}
	
	@Transactional 
	public void save(Skill employee) { 
	 LOGGER.info("Start"); 
     skillRepository.save(employee); 
	 LOGGER.info("End"); 
	}

}
