package yss.shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import yss.shop.adminuser.entity.AdminUser;
/*
 * 后台登录的Dao类
 */
public class AdminUserDao extends HibernateDaoSupport{
	
	// Dao层后台用户登录的方法
	public AdminUser login(AdminUser adminUser) {
		// TODO Auto-generated method stub
		String hql="from AdminUser au where au.username =? and au.password =?";
		List<AdminUser> list = (List<AdminUser>) this.getHibernateTemplate().find(hql,new String[]{adminUser.getUsername(),adminUser.getPassword()});
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
