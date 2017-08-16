package ljl.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jinliang on 2017/4/18.
 */
@RequestMapping("/freemarker")
@Controller
public class FreeMarkerController {


    @RequestMapping("/list")
    public String list(Map<String, Object> model) {
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            Map m = new HashMap();
            m.put("key"+i,"值1"+i);
            m.put("key"+i+1,"值2"+i+1);
            m.put("key"+i+2,"值2"+i+2);
            list.add(m);
        }
        model.put("list",list);
        return "main/index";
    }

}
