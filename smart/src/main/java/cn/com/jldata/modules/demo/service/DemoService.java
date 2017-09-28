package cn.com.jldata.modules.demo.service;

import cn.com.jldata.common.entity.Employee;
import cn.com.jldata.core.query.PropertyFilter;
import cn.com.jldata.modules.demo.vo.DemoRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DemoService {
    Page<Employee> selectEmployeeList(DemoRequest demoRequest, Pageable pageable);

    Page<Employee> selectEmployeeListFilter(List<PropertyFilter> propertyFilters, PageRequest pageRequest);
}
