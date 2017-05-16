package com.ljl.dao;

import com.ljl.domain.ClassEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Mapper
public interface ClassDao {
    public List<ClassEntity> selectClassList();
}
