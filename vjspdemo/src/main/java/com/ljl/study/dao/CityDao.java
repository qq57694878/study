package com.ljl.study.dao;

import com.ljl.study.entity.City;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jinliang on 2017/4/18.
 */

public interface CityDao {
    public City selectCityById(String id);

    public void insertCity(City city);

    void updateCity(City city);

    void deleteCity(String id);
}
