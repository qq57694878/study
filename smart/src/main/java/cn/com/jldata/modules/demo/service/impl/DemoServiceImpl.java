package cn.com.jldata.modules.demo.service.impl;

import cn.com.jldata.common.entity.Employee;
import cn.com.jldata.core.jpa.JpaQueryUtil;
import cn.com.jldata.core.query.PropertyFilter;
import cn.com.jldata.modules.demo.dao.DemoDao;
import cn.com.jldata.modules.demo.service.DemoService;
import cn.com.jldata.modules.demo.vo.DemoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;
    public Page<Employee> selectEmployeeList(DemoRequest demoRequest,Pageable pageable) {
        Employee employee = new Employee();
        employee.setLastName(demoRequest.getLastName());
        employee.setId(Integer.parseInt(demoRequest.getId()));
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
                .withMatcher("id",ExampleMatcher.GenericPropertyMatchers.caseSensitive())
                .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<Employee> ex = Example.of(employee, matcher);
        Sort sort = new Sort(Sort.Direction.ASC,"id");

        Pageable pageRequest = new PageRequest(pageable.getPageNumber(),pageable.getPageSize(),sort);
        return demoDao.findAll(ex,pageRequest);
    }

    public Page<Employee> selectEmployeeListSpecification(DemoRequest demoRequest) {

        Sort sort = new Sort(Sort.Direction.ASC,"id");

        Pageable pageable = new PageRequest(0,2,sort);
        return demoDao.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
/*
                root.get("").get()
                criteriaBuilder.between()*/
                return null;
            }
        },pageable);
    }

    @Override
    public Page<Employee> selectEmployeeListFilter(List<PropertyFilter> propertyFilters, PageRequest pageRequest) {
        Sort sort = new Sort(Sort.Direction.ASC,"id");

        Pageable pageable = new PageRequest(0,2,sort);
        return demoDao.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               return JpaQueryUtil.getPredicate(root,criteriaBuilder,propertyFilters);
            }
        },pageable);
    }
}
