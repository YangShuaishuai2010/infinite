package yss.shop.order.service;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import yss.shop.order.dao.OrderDao;
import yss.shop.order.entity.Order;
import yss.shop.order.entity.OrderItem;
import yss.shop.product.entity.Product;
import yss.shop.utils.PageBean;

/*
 * 订单模块：业务层代码：
 */
@Transactional
public class OrderService {
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	// 保存订单的业务层代码
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}
	// 我的订单的业务层代码：
	public PageBean<Order> findByPageUid(Integer uid, Integer currentPage) {
		// TODO Auto-generated method stub
		PageBean<Order> pageBean=new PageBean<Order>();
		// 设置当前页数
		pageBean.setCurrentPage(currentPage);
		// 设置每页显示的记录数
		int pageSize=5;
		pageBean.setPageSize(pageSize);
		// 设置总的记录数
		int totalCount=orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage=0;
		if(totalCount%pageSize==0){
			totalPage=totalCount/pageSize;
		}else{
			totalPage=totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据的集合
		Integer beginPage = (currentPage - 1)* pageSize;
		List<Order> list = orderDao.findByPageUid(uid,beginPage,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	// 根据订单的oid查询订单的方法
	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		
		return orderDao.findByOid(oid);
	}
	// 业务层：修改订单的方法
	public void update(Order currOrder) {
		// TODO Auto-generated method stub
		orderDao.update(currOrder);
	}
	// 业务层：后台分页查询订单的执行的方法
	public PageBean<Order> findByPage(Integer currentPage) {
		// TODO Auto-generated method stub
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置当前页
		pageBean.setCurrentPage(currentPage);
		// 设置总计录数
		int totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置每页显示的记录数
		int pageSize = 10;

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
		List<Order> list = orderDao.findByPage(beginPage,pageSize);
		// 将list集合封装到PageBean对象中
		pageBean.setList(list);
		return pageBean;
	}
	// 业务层根据订单oid查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findOrderItem(oid);
	}
	

}
