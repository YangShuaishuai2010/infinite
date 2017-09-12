package yss.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import yss.shop.order.entity.Order;
import yss.shop.order.entity.OrderItem;
import yss.shop.utils.PageHibernateCallback;

/*
 * 订单模块的 Dao层的代码：
 */
public class OrderDao extends HibernateDaoSupport {
	// Dao层保存订单的方法
	public void save(Order order) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(order);
	}
	// Dao层的我的订单的个数统计
	public Integer findByCountUid(int uid) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Order o where o.user.uid=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,uid);
		System.out.println(list.size()+":::::::::::list.size()::::::::::");
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	// Dao层我得订单的查询
	public List<Order> findByPageUid(int uid, int beginPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Order o where o.user.uid=? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, beginPage, pageSize));
		
		return list;
	}
	// 根据订单的oid查询订单的方法
	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Order.class,oid);
	}
	// Dao层：修改订单的方法
	public void update(Order currOrder) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(currOrder);
	}
	//Dao层：统计订单个数的方法
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Order";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//Dao层： 带分页查询的方法
	public List<Order> findByPage(int beginPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, beginPage, pageSize));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	// Dao层根据订单oid查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		// TODO Auto-generated method stub
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = (List<OrderItem>) this.getHibernateTemplate().find(hql, oid);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	

}
