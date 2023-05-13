package com.idstar.service;

import java.util.List;

import com.idstar.model.Rekening;

public interface RekeningService {
	Rekening save(Rekening param);
	Rekening update(Rekening param);
	List<Rekening> findAll();
	List<Rekening> findAllCustom(int offset, int limit);
	Rekening findById(int id);
	void delete(int id);
}
