package cn.com.jldata.modules.demo.service;

import cn.com.jldata.common.entity.Employee;
import cn.com.jldata.modules.demo.vo.DemoRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DemoService {
    Page<Employee> selectEmployeeList(DemoRequest demoRequest);
}
