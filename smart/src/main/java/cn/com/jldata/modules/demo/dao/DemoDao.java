package cn.com.jldata.modules.demo.dao;

import cn.com.jldata.common.entity.Employee;
import cn.com.jldata.core.jpa.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoDao extends BaseRepository<Employee,Integer>{

}
