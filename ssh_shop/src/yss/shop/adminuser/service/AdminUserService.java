package yss.shop.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import yss.shop.adminuser.dao.AdminUserDao;
import yss.shop.adminuser.entity.AdminUser;
/*
 * 后台登录的业务层类
 */
@Transactional
public class AdminUserService {
	// 注入Dao
	private AdminUserDao adminUserDao;
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	// 业务层后台用户登录的方法
	public AdminUser login(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return adminUserDao.login(adminUser);
	}
	

}
