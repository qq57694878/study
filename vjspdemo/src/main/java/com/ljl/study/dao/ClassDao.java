package com.ljl.study.dao;

import com.ljl.study.entity.ClassEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Mapper
public interface ClassDao {
    public List<ClassEntity> selectClassList();
}
