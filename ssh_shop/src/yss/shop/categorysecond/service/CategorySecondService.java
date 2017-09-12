package yss.shop.categorysecond.service;

import java.util.List;

import yss.shop.categorysecond.dao.CategorySecondDao;
import yss.shop.categorysecond.entity.CategorySecond;
import yss.shop.product.entity.Product;
import yss.shop.utils.PageBean;
/*
 * 二级分类管理的业务层类
 */
public class CategorySecondService {
	// 注入二级分类的Dao
	private CategorySecondDao categorySecondDao;
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	// 业务层分页查询二级分类的方法
	public PageBean<CategorySecond> findByPage(Integer currentPage) {
		// TODO Auto-generated method stub
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		// 设置当前页
		pageBean.setCurrentPage(currentPage);
		// 总计录数
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 总页数
		// 总记录数 除以 每页显示记录数 取余数 判断是否能够整除
		int totalPage = 0;
		if (totalCount % pageSize == 0) {// 表示能整除
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 开始位置(从哪儿开始)
		int beginPage = (currentPage - 1) * pageSize;
		// 每页显示记录的list集合
		List<CategorySecond> list = categorySecondDao.findByPage(beginPage,pageSize);
		// 将list集合封装到PageBean对象中
		pageBean.setList(list);
		return pageBean;
	}
	// 业务层保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.save(categorySecond);
	}
	// 业务层根据二级分类的csid查询二级分类的方法
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return categorySecondDao.findByCsid(csid);
	}
	// 业务层删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.delete(categorySecond);
	}
	// 业务层修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.update(categorySecond);
	}
	// 业务层查询所有的二级分类的方法
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll();
	}
	

}
