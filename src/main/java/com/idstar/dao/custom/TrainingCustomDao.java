package com.idstar.dao.custom;

import java.util.List;

import com.idstar.model.Training;

public interface TrainingCustomDao {
    List<Training> findAllDatas(int offset, int limit);
}
