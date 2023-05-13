package com.idstar.service;

import java.util.List;

import com.idstar.model.Karyawan;

public interface KaryawanService {
	Karyawan save(Karyawan param);
	Karyawan update(Karyawan param);
	List<Karyawan> findAll();
	List<Karyawan> findAllCustom(int offset, int limit);
	Karyawan findById(int id);
	void delete(int id);
}
