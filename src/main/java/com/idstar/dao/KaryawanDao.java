package com.idstar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idstar.model.Karyawan;

public interface KaryawanDao extends CrudRepository<Karyawan, Integer> {
	@Query("FROM Karyawan")
    List<Karyawan> findAllDatas();
}
