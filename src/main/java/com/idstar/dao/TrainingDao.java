package com.idstar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idstar.model.Training;

public interface TrainingDao extends CrudRepository<Training, Integer> {
	@Query("FROM Training")
    List<Training> findAllDatas();
}
