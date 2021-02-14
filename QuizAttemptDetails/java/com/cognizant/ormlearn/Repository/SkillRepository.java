package com.cognizant.ormlearn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

	

}
