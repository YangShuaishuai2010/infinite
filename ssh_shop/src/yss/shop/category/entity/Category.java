package yss.shop.category.entity;

import java.util.HashSet;
import java.util.Set;

import yss.shop.categorysecond.entity.CategorySecond;

/*
 * 一级分类的实体类对象
 */
public class Category {
	private Integer cid;
	private String cname;
	// 一级分类中存放二级分类的集合
	private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
