package com.ljl.controller;

import com.ljl.dao.CityDao;
import com.ljl.dao.ClassDao;
import com.ljl.domain.City;
import com.ljl.domain.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jinliang on 2017/4/18.
 */
@RequestMapping("/class")
@RestController
public class ClassController {
    @Autowired
    private ClassDao classDao;

    @RequestMapping("/list")
    public List<ClassEntity> selectClassList() {
        List<ClassEntity> list = classDao.selectClassList();
        if (list != null) {
            for (ClassEntity i:list) {
                System.out.print(i);
                System.out.println();
            }
            return list;
        }
        return null;
    }

}
