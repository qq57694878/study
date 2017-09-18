package cn.com.jldata.modules.demo.controller;

import cn.com.jldata.common.entity.Employee;
import cn.com.jldata.core.vo.RestResult;
import cn.com.jldata.modules.demo.service.DemoService;
import cn.com.jldata.modules.demo.vo.DemoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;
    @RequestMapping("/list")
    public RestResult list(@RequestBody DemoRequest demoRequest){
        Page<Employee> page =  demoService.selectEmployeeList(demoRequest);
        return new RestResult(page);
    }
}
