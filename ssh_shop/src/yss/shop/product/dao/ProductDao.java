package yss.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import yss.shop.product.entity.Product;
import yss.shop.utils.PageHibernateCallback;
/*
 * 商品的持久层代码
 */
public class ProductDao extends HibernateDaoSupport {
	// 首页上热门商品的查询
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		// 1使用离线条件查询：
		// 2使用
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		// 使用热门的商品，条件就是is_host = 1
		criteria.add(Restrictions.eq("is_hot",1));
		// 倒叙排序输出，让最新的热门商品，先输出显示到页面
		criteria.addOrder(Order.desc("pDate"));
		// 执行查询就可以了
		List<Product> list=(List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
		return list;
	}
	
	// 首页上最新商品的查询
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		// 使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		// 按日期进行倒序排序
		criteria.addOrder(Order.desc("pDate"));
		// 执行查询：
		List<Product> list=(List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
		return list;
	}
	// 根据商品的pid查询商品
	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	
	// 根据分类的cid查询商品总记录数
	public int findCount(Integer cid) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql, cid);
		if(list!=null&& list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	// 根据分类cid查询商品的集合
	public List<Product> findByPageCid(Integer cid, int beginPage, int pageSize) {
		// TODO Auto-generated method stub
		// sql语句： select p.* from t_category c,t_categorysecond cs,t_product p where c.cid=cs.cid and cs.csid=p.csid and c.cid=2
		// hql语句： select p from Category c,CategorySecond cs,Product p where c.cid=cs.category.cid and cs.csid=p.categorySecond.csid and c.cid=2
		// 简化后的hql
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		// 分页的另一种写法：
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid} , beginPage, pageSize));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	// 根据二级分类的csid查询商品记录数
	public int findCountCsid(Integer csid) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql, csid);
		if(list!=null&& list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	// 根据二级分类的csid查询商品
	public List<Product> findByPageCsid(Integer csid, int beginPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql="select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{csid},beginPage,pageSize));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	// Dao层统计商品个数的方法
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Product";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	// 带分页的查询商品的方法
	public List<Product> findByPage(int beginPage, int pageSize) {
		// TODO Auto-generated method stub 
		String hql="from Product order by pDate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, beginPage, pageSize));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	// Dao层保持商品的方法
	public void save(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(product);
	}

	// Dao层删除商品的方法
	public void delete(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(product);
	}

	// Dao层修改商品的数据到数据库
	public void update(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(product);
	}
	

}
