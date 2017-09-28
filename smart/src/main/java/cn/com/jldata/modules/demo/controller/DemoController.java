package cn.com.jldata.modules.demo.controller;

import cn.com.jldata.common.entity.Employee;
import cn.com.jldata.core.query.PropertyFilter;
import cn.com.jldata.core.vo.RestResult;
import cn.com.jldata.modules.demo.service.DemoService;
import cn.com.jldata.modules.demo.vo.DemoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;
    @RequestMapping("/list")
    public RestResult list(@RequestBody DemoRequest demoRequest, @ModelAttribute PageRequest pageRequest){
        Page<Employee> page =  demoService.selectEmployeeList(demoRequest,pageRequest);
        return new RestResult(page);
    }

    @RequestMapping("/listFilter")
    public RestResult listFilter(@RequestBody Map<String,Object> demoRequest){
        PageRequest pageRequest = new PageRequest(Integer.parseInt(String.valueOf(demoRequest.get("page"))),Integer.parseInt(String.valueOf(demoRequest.get("size"))));
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(demoRequest);
        Page<Employee> page =  demoService.selectEmployeeListFilter(propertyFilters,pageRequest);
        return new RestResult(page);
    }
}
