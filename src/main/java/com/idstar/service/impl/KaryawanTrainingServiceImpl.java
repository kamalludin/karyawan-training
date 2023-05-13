package com.idstar.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idstar.dao.KaryawanDao;
import com.idstar.dao.KaryawanTrainingDao;
import com.idstar.dao.TrainingDao;
import com.idstar.dao.custom.KaryawanTrainingCustomDao;
import com.idstar.model.Karyawan;
import com.idstar.model.KaryawanTraining;
import com.idstar.model.Training;
import com.idstar.service.KaryawanTrainingService;

@Service(value="karyawanTrainingService")
public class KaryawanTrainingServiceImpl implements KaryawanTrainingService {
	
	@Autowired
	private KaryawanTrainingDao karyawanTrainingDao;
	
	@Autowired
	private KaryawanTrainingCustomDao karyawanTrainingCustomDao;
	
	@Autowired
	private KaryawanDao karyawanDao;
	
	@Autowired
	private TrainingDao trainingDao;
	
	@Override
	public KaryawanTraining save(KaryawanTraining param) {
		KaryawanTraining karyawanTraining = new KaryawanTraining();
		
		Optional<Karyawan> karyawanOpt = karyawanDao.findById(param.getKaryawan().getId());
		Karyawan karyawan = karyawanOpt.get();
		karyawanTraining.setKaryawan(karyawan);
		
		Optional<Training> trainingOpt = trainingDao.findById(param.getTraining().getId());
		Training training = trainingOpt.get();
		karyawanTraining.setTraining(training);
		
		karyawanTraining.setTanggal(param.getTanggal());
		
		return karyawanTrainingDao.save(karyawanTraining);
	}
	
	@Override
	public KaryawanTraining update(KaryawanTraining param) {
		Optional<KaryawanTraining> karyawanTrainingOpt = karyawanTrainingDao.findById(param.getId());
		KaryawanTraining karyawanTraining = karyawanTrainingOpt.get();
		
		Optional<Karyawan> karyawanOpt = karyawanDao.findById(param.getKaryawan().getId());
		Karyawan karyawan = karyawanOpt.get();
		karyawanTraining.setKaryawan(karyawan);
		
		Optional<Training> trainingOpt = trainingDao.findById(param.getTraining().getId());
		Training training = trainingOpt.get();
		karyawanTraining.setTraining(training);
		
		karyawanTraining.setTanggal(param.getTanggal());
		karyawanTraining.setUpdatedDate(new Date());
		karyawanTrainingDao.save(karyawanTraining);

		return karyawanTraining;
	}
	
	@Override
	public List<KaryawanTraining> findAll() {
		return karyawanTrainingDao.findAllDatas();
	}
	
	@Override
	public List<KaryawanTraining> findAllCustom(int offset, int limit) {
		return karyawanTrainingCustomDao.findAllDatas(offset, limit);
	}
	
	@Override
	public KaryawanTraining findById(int id) {
		Optional<KaryawanTraining> karyawanTrainingOpt = karyawanTrainingDao.findById(id);
		KaryawanTraining karyawanTraining = karyawanTrainingOpt.get();
		return karyawanTraining;
	}
	
	@Override
	public void delete(int id) {
		karyawanTrainingDao.deleteById(id);
	}
}
