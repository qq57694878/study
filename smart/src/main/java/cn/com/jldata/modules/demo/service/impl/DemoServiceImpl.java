package cn.com.jldata.modules.demo.service.impl;

import cn.com.jldata.common.entity.Employee;
import cn.com.jldata.modules.demo.dao.DemoDao;
import cn.com.jldata.modules.demo.service.DemoService;
import cn.com.jldata.modules.demo.vo.DemoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;
    public Page<Employee> selectEmployeeList(DemoRequest demoRequest) {
        Employee employee = new Employee();
        employee.setLastName("test");
        employee.setId(1);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
                .withMatcher("id",ExampleMatcher.GenericPropertyMatchers.caseSensitive())
                .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Example<Employee> ex = Example.of(employee, matcher);
        Pageable pageable = new PageRequest(1,2,sort);
        return demoDao.findAll(ex,pageable);
    }
}
