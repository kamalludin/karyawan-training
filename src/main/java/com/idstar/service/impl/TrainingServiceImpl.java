package com.idstar.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idstar.dao.TrainingDao;
import com.idstar.dao.custom.TrainingCustomDao;
import com.idstar.model.Training;
import com.idstar.service.TrainingService;

@Service(value="trainingService")
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	private TrainingDao trainingDao;
	
	@Autowired
	private TrainingCustomDao trainingCustomDao;
	
	@Override
	public Training save(Training param) {
		return trainingDao.save(param);
	}
	
	@Override
	public Training update(Training param) {
		Optional<Training> trainingOpt = trainingDao.findById(param.getId());
		Training Training = trainingOpt.get();

		Training.setPengajar(param.getPengajar());
		Training.setTema(param.getTema());
		Training.setUpdatedDate(new Date());
		trainingDao.save(Training);

		return Training;
	}
	
	@Override
	public List<Training> findAll() {
		return trainingDao.findAllDatas();
	}
	
	@Override
	public List<Training> findAllCustom(int offset, int limit) {
		return trainingCustomDao.findAllDatas(offset, limit);
	}
	
	@Override
	public Training findById(int id) {
		Optional<Training> TrainingOpt = trainingDao.findById(id);
		Training Training = TrainingOpt.get();
		return Training;
	}
	
	@Override
	public void delete(int id) {
		trainingDao.deleteById(id);
	}
}
