package com.idstar.dao.custom;

import java.util.List;

import com.idstar.model.Karyawan;

public interface KaryawanCustomDao {
    List<Karyawan> findAllDatas(int offset, int limit);
}
