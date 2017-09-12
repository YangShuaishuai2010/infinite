
package yss.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import yss.shop.category.entity.Category;

/*
 * 一级分类的持久化层对象
 */
public class CategoryDao extends HibernateDaoSupport {
	// Dao层的查询所有一级分类的方法
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String hql="from Category";
		System.out.println(hql);
		List<Category> list=(List<Category>) this.getHibernateTemplate().find(hql);
		return list;
	}
	// Dao层的后台保存一级分类的方法：
	public void save(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(category);
	}
	// Dao层根据cid查询一级分类
	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Category.class,cid);
	}
	// Dao层删除一级分类的方法 
	public void delete(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(category);
	}
	// Dao层修改一级分类的方法
	public void update(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(category);
		
	}

}
