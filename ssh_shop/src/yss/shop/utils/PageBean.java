package yss.shop.utils;

import java.util.List;

/*
 * 做页面分页用的实体类
 * */
public class PageBean<T> {
	// 当前页
	private Integer currentPage;
	// 总记录数
	private Integer totalCount;
	// 每页显示记录数
	private Integer pageSize;
	// 总页数
	private Integer totalPage;
	// 开始位置
	private Integer beginPage;
	// 每页记录的list集合
	private List<T> list;
	// 
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(Integer beginPage) {
		this.beginPage = beginPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
