package yss.shop.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import yss.shop.adminuser.entity.AdminUser;

/*
 * 后台权限校验的拦截器
 * * 对没有登录的用户不可以访问
 */
public class PrivilegeIntercept extends MethodFilterInterceptor{
	// 执行拦截的方法
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		// 判断session中是否保存了后台用户的信息：
		AdminUser existAdminUser = (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existAdminUser");
		if(existAdminUser == null){
			// 没有登录进行访问：
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
			actionSupport.addActionError("亲！您还没有登录！没有权限访问！");
			return "loginFail";
		}else{
			// 已经登录过：
			return actionInvocation.invoke();
		}
	}

}
