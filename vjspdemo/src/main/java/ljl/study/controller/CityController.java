package ljl.study.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ljl.study.mapper.CityDao;
import ljl.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by jinliang on 2017/4/18.
 */
@RequestMapping("/city")
@RestController
public class CityController {
    @Autowired
    private CityDao cityDao;

    @RequestMapping("/selectAll")
    public Object selectCityAll(HttpServletRequest request) {
        PageHelper.startPage(request);
        List<City> list = cityDao.selectCityAll();
        if (list != null) {
            Page<City> citys = (Page<City>)list;
            citys.getTotal();
            System.out.println(citys.toString());
            return citys;
        }
        return "未找到";
    }

    @RequestMapping("/select/{id}")
    public Object selectCityById(@PathVariable("id") String id) {
        City city = cityDao.selectCityById(id);
        if (city != null) {
            return city.toString();
        }
        return "未找到";
    }

    @RequestMapping("/save")
    public Object saveCity(@RequestBody City city) {
        if (city.getId() != null && city.getId().length() > 0) {
            cityDao.updateCity(city);
        } else {
            cityDao.insertCity(city);
        }

        return "id:" + city.getId();
    }

    @RequestMapping("/delete/{id}")
    public Object deleteCity(@PathVariable("id") String id) {
        cityDao.deleteCity(id);
        return "删除成功";
    }
    @RequestMapping("/a")
    public Object a() {
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
