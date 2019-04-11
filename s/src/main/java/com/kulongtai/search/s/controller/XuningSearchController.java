package com.kulongtai.search.s.controller;

import com.kulongtai.search.s.common.RestResult;
import com.kulongtai.search.s.model.Article;
import com.kulongtai.search.s.service.XuningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Title: XuningSearchController
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/11 15:07
 */
@RequestMapping("/xuning")
@Controller
public class XuningSearchController {
	@Autowired
	private XuningService xuningService;
	@RequestMapping(value = "s",method = RequestMethod.GET)
	public String search(@RequestParam("q") String q,@RequestParam("pageNumber") int pageNumber,@RequestParam("pageSize") int pageSize,
			PageParam ppp ) throws Exception {
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		Page<Article> list  = xuningService.search(q,pageable);
		return "search.html";
	}
}
