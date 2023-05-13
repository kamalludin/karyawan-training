package com.idstar.dao.custom.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.idstar.dao.custom.KaryawanTrainingCustomDao;
import com.idstar.model.KaryawanTraining;

@Repository
public class KaryawanTrainingCustomDaoImpl implements KaryawanTrainingCustomDao {

	private static final String TABLE_NAME = KaryawanTraining.class.getName();

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<KaryawanTraining> findAllDatas(int offset, int limit) {
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
