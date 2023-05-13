package com.idstar.service;

import java.util.List;

import com.idstar.model.KaryawanTraining;

public interface KaryawanTrainingService {
	KaryawanTraining save(KaryawanTraining param);
	KaryawanTraining update(KaryawanTraining param);
	List<KaryawanTraining> findAll();
	List<KaryawanTraining> findAllCustom(int offset, int limit);
	KaryawanTraining findById(int id);
	void delete(int id);
}
