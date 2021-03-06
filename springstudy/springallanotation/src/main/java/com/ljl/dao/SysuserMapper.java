package com.ljl.dao;

import com.ljl.entity.Sysuser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysuserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSUSER
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSUSER
     *
     * @mbg.generated
     */
    int insert(Sysuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSUSER
     *
     * @mbg.generated
     */
    int insertSelective(Sysuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSUSER
     *
     * @mbg.generated
     */
    Sysuser selectByPrimaryKey(String userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSUSER
     *
     * @mbg.generated
     */
    Sysuser selectByUsercode(String usercode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSUSER
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Sysuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSUSER
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Sysuser record);
}