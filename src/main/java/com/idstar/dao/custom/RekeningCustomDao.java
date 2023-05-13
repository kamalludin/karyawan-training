package com.idstar.dao.custom;

import java.util.List;

import com.idstar.model.Rekening;

public interface RekeningCustomDao {
    List<Rekening> findAllDatas(int offset, int limit);
}
