package com.kulongtai.search.s.model;

import java.util.Date;
import java.util.List;

/**
 * Title: Article
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/4 17:00
 */
public class Article {
	private String id;
	private String title;
	private String content;
	private List<String> filenames;
	private String type;
	private String remark;
	private Date create_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getFilenames() {
		return filenames;
	}

	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
