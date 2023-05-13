package com.idstar.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idstar.dao.KaryawanDao;
import com.idstar.dao.RekeningDao;
import com.idstar.dao.custom.RekeningCustomDao;
import com.idstar.model.Karyawan;
import com.idstar.model.Rekening;
import com.idstar.service.RekeningService;

@Service(value="rekeningService")
public class RekeningServiceImpl implements RekeningService {
	
	@Autowired
	private RekeningDao rekeningDao;
	
	@Autowired
	private RekeningCustomDao rekeningCustomDao;
	
	@Autowired
	private KaryawanDao karyawanDao;
	
	@Override
	public Rekening save(Rekening param) {
		Optional<Karyawan> karyawanOpt = karyawanDao.findById(param.getKaryawan().getId());
		Karyawan karyawan = karyawanOpt.get();
		param.setKaryawan(karyawan);
		
		return rekeningDao.save(param);
	}
	
	@Override
	public Rekening update(Rekening param) {
		Optional<Rekening> rekeningOpt = rekeningDao.findById(param.getId());
		Rekening Rekening = rekeningOpt.get();

		Rekening.setJenis(param.getJenis());
		Rekening.setNama(param.getNama());
		Rekening.setRekening(param.getRekening());
		
		Optional<Karyawan> karyawanOpt = karyawanDao.findById(param.getKaryawan().getId());
		Karyawan karyawan = karyawanOpt.get();
		
		Rekening.setKaryawan(karyawan);
		Rekening.setUpdatedDate(new Date());
		rekeningDao.save(Rekening);

		return Rekening;
	}
	
	@Override
	public List<Rekening> findAll() {
		return rekeningDao.findAllDatas();
	}
	
	@Override
	public List<Rekening> findAllCustom(int offset, int limit) {
		return rekeningCustomDao.findAllDatas(offset, limit);
	}
	
	@Override
	public Rekening findById(int id) {
		Optional<Rekening> RekeningOpt = rekeningDao.findById(id);
		Rekening Rekening = RekeningOpt.get();
		return Rekening;
	}
	
	@Override
	public void delete(int id) {
		rekeningDao.deleteById(id);
	}
}
