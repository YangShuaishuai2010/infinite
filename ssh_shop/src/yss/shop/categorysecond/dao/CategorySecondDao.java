package yss.shop.categorysecond.dao;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import yss.shop.categorysecond.entity.CategorySecond;
import yss.shop.utils.PageHibernateCallback;
/*
 * 二级分类管理的Dao层类
 */
public class CategorySecondDao extends HibernateDaoSupport {
	// Dao层统计二级分类的个数的方法
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from CategorySecond";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list !=null && list.size()>0	){
			return list.get(0).intValue();
		}
		return 0;
	}
	// Dao层分页查询二级分类的方法
	public List<CategorySecond> findByPage(int beginPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from CategorySecond order by csid desc";//按照csid倒序的排个序
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, null, beginPage, pageSize));
		if(list !=null && list.size()>0	){
			return list;
		}
		return null;
	}
	// Dao层保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(categorySecond);
	}
	// Dao层根据二级分类的csid查询二级分类的方法
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(CategorySecond.class,csid);
	}
	// Dao层删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(categorySecond);
	}
	// Dao层修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(categorySecond);
	}
	//Dao层查询所有的二级分类的方法
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		String hql = "from CategorySecond";
		return (List<CategorySecond>) this.getHibernateTemplate().find(hql);
	}

}
