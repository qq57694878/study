package com.ljl.study.mapper;

import com.ljl.entity.ClassEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */

public interface ClassDao {
    public List<ClassEntity> selectClassList();
}
