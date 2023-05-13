package com.idstar.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idstar.dao.DetailKaryawanDao;
import com.idstar.dao.KaryawanDao;
import com.idstar.dao.custom.KaryawanCustomDao;
import com.idstar.model.DetailKaryawan;
import com.idstar.model.Karyawan;
import com.idstar.service.KaryawanService;

@Service(value="karyawanService")
public class KaryawanServiceImpl implements KaryawanService {
	
	@Autowired
	private KaryawanDao karyawanDao;
	
	@Autowired
	private KaryawanCustomDao karyawanCustomDao;
	
	@Autowired
	private DetailKaryawanDao detailKaryawanDao;
	
	@Override
	public Karyawan save(Karyawan param) {
		DetailKaryawan detailKaryawan = detailKaryawanDao.save(param.getDetailKaryawan());
		param.setDetailKaryawan(detailKaryawan);
		return karyawanDao.save(param);
	}
	
	@Override
	public Karyawan update(Karyawan param) {
		Optional<Karyawan> karyawanOpt = karyawanDao.findById(param.getId());
		Karyawan karyawan = karyawanOpt.get();
		
		karyawan.setNama(param.getNama());
		karyawan.setAlamat(param.getAlamat());
		karyawan.setDob(param.getDob());
		karyawan.setStatus(param.getStatus());
		karyawan.setUpdatedDate(new Date());
		karyawanDao.save(karyawan);
		
		Optional<DetailKaryawan> detailKaryawanOpt = detailKaryawanDao.findById(param.getDetailKaryawan().getId());
		DetailKaryawan detailKaryawan = detailKaryawanOpt.get();
		detailKaryawan.setNik(param.getDetailKaryawan().getNik());
		detailKaryawan.setNpwp(param.getDetailKaryawan().getNpwp());
		detailKaryawan.setUpdatedDate(new Date());
		detailKaryawanDao.save(detailKaryawan);

		return karyawan;
	}
	
	@Override
	public List<Karyawan> findAll() {
		return karyawanDao.findAllDatas();
	}
	
	@Override
	public List<Karyawan> findAllCustom(int offset, int limit) {
		return karyawanCustomDao.findAllDatas(offset, limit);
	}
	
	@Override
	public Karyawan findById(int id) {
		Optional<Karyawan> karyawanOpt = karyawanDao.findById(id);
		Karyawan karyawan = karyawanOpt.get();
		return karyawan;
	}
	
	@Override
	public void delete(int id) {
		karyawanDao.deleteById(id);
	}
}
