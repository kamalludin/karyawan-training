package com.idstar.dao.custom;

import java.util.List;

import com.idstar.model.KaryawanTraining;

public interface KaryawanTrainingCustomDao {
    List<KaryawanTraining> findAllDatas(int offset, int limit);
}
