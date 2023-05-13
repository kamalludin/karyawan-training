package com.idstar.dao.custom.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.idstar.dao.custom.TrainingCustomDao;
import com.idstar.model.Training;

@Repository
public class TrainingCustomDaoImpl implements TrainingCustomDao {

	private static final String TABLE_NAME = Training.class.getName();

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Training> findAllDatas(int offset, int limit) {
		StringBuffer query = new StringBuffer();
		Query que = null;
		try {
			query.append("SELECT x FROM " + TABLE_NAME + " x ");

			que = entityManager.createQuery(query.toString());

			if (offset >= 0) {
				que.setFirstResult(offset);
			}
			if (limit > 0) {
				que.setMaxResults(limit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return que.getResultList();
	}

}
