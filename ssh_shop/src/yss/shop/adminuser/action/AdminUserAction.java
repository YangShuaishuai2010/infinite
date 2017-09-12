package yss.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yss.shop.adminuser.entity.AdminUser;
import yss.shop.adminuser.service.AdminUserService;
/*
 * 后台登录的Action
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	// 注入service
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	// 模型驱动使用的对象
	private AdminUser adminUser = new AdminUser();
	@Override
	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}
	// 后台登录的方法
	public String login(){
		// 调用service完成登录：
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser != null ){
			// 登录成功
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser",existAdminUser);
			return "loginSuccess";			
		}
		// 登录失败
		this.addActionError("亲！您的用户名或者密码错误，请检查后重新登录！");
		return "loginFail";		
	}

}
