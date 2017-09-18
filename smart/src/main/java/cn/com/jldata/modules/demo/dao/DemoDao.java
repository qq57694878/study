package cn.com.jldata.modules.demo.dao;

import cn.com.jldata.common.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoDao extends JpaRepository<Employee,Integer>,JpaSpecificationExecutor<Employee> {

}
