package com.idstar.service;

import java.util.List;

import com.idstar.model.Training;

public interface TrainingService {
	Training save(Training param);
	Training update(Training param);
	List<Training> findAll();
	List<Training> findAllCustom(int offset, int limit);
	Training findById(int id);
	void delete(int id);
}
