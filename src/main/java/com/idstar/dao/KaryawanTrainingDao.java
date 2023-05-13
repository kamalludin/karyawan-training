package com.idstar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idstar.model.KaryawanTraining;

public interface KaryawanTrainingDao extends CrudRepository<KaryawanTraining, Integer> {
	@Query("FROM KaryawanTraining")
    List<KaryawanTraining> findAllDatas();
}
