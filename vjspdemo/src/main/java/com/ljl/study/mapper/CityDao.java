package com.ljl.study.mapper;

import com.ljl.entity.City;

import java.util.List;

/**
 * Created by jinliang on 2017/4/18.
 */

public interface CityDao {
    public City selectCityById(String id);

    public void insertCity(City city);

    void updateCity(City city);

    void deleteCity(String id);

    List<City> selectCityAll();
}
