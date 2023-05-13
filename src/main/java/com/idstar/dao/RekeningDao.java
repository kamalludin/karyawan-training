package com.idstar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idstar.model.Rekening;

public interface RekeningDao extends CrudRepository<Rekening, Integer> {
	@Query("FROM Rekening")
    List<Rekening> findAllDatas();
}
