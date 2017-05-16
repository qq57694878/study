package com.ljl.controller;

import com.ljl.dao.CityDao;
import com.ljl.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinliang on 2017/4/18.
 */
@RequestMapping("/city")
@RestController
public class CityController {
    @Autowired
    private CityDao cityDao;

    @RequestMapping("/select/{id}")
    public String selectCityById(@PathVariable("id") String id) {
        City city = cityDao.selectCityById(id);
        if (city != null) {
            return city.toString();
        }
        return "未找到";
    }

    @RequestMapping("/save")
    public String saveCity(@RequestBody City city) {
        if (city.getId() != null && city.getId().length() > 0) {
            cityDao.updateCity(city);
        } else {
            cityDao.insertCity(city);
        }

        return "id:" + city.getId();
    }

    @RequestMapping("/delete/{id}")
    public String deleteCity(@PathVariable("id") String id) {
        cityDao.deleteCity(id);
        return "删除成功";
    }
    @RequestMapping("/a")
    public String a() {
        System.out.println(Thread.currentThread().getId());
        synchronized (this){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String bb = "";
            bb = "1231232";
            System.out.println(bb);
        }
        return "success";
    }
}
