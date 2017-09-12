package yss.shop.product.service;

import java.util.List;
import yss.shop.product.dao.ProductDao;
import yss.shop.product.entity.Product;
import yss.shop.utils.PageBean;

/*
 * 商品的业务层代码
 */
public class ProductService {
	// 注入ProductDao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	// 首页上热门商品的查询
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}

	// 首页上最新商品的查询
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}

	// 根据商品的pid查询商品
	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findByPid(pid);
	}

	// 根据一级分类的cid带有分页的查询
	public PageBean<Product> findByPageCid(Integer cid, int currentPage) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页
		pageBean.setCurrentPage(currentPage);
		// 总计录数
		int totalCount = productDao.findCount(cid);
		pageBean.setTotalCount(totalCount);
		// 每页显示的记录数
		int pageSize = 8;

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
		List<Product> list = productDao.findByPageCid(cid,beginPage,pageSize);
		// 将list集合封装到PageBean对象中
		pageBean.setList(list);
		return pageBean;


	}

	// 根据二级分类的csid查询商品
	public PageBean<Product> findByPageCsid(Integer csid, int currentPage) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页
		pageBean.setCurrentPage(currentPage);
		// 总计录数
		int totalCount = productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		// 每页显示的记录数
		int pageSize = 8;

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
		List<Product> list = productDao.findByPageCsid(csid,beginPage,pageSize);
		// 将list集合封装到PageBean对象中
		pageBean.setList(list);
		return pageBean;
	}
	// 业务层查询商品带分页的方法
	public PageBean<Product> findByPage(Integer currentPage) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页
		pageBean.setCurrentPage(currentPage);
		// 总计录数
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 设置总页数
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
		// 设置每页显示记录的list集合
		List<Product> list = productDao.findByPage(beginPage,pageSize);
		// 将list集合封装到PageBean对象中
		pageBean.setList(list);
		return pageBean;
	}
	// 业务层保持商品的方法
	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}
	// 业务层删除商品的方法
	public void delete(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}
	// 业务层修改商品的数据到数据库
	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

}
