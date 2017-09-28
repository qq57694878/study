package cn.com.jldata.common.dao;

import cn.com.jldata.common.entity.SysUserEntity;
import cn.com.jldata.core.jpa.BaseRepository;

public interface SysUserRepository extends BaseRepository<SysUserEntity,Integer>{
    @Override
    SysUserEntity findOne(Integer integer);
}
