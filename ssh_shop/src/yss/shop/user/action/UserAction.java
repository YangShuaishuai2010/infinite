package yss.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yss.shop.user.entity.User;
import yss.shop.user.service.UserService;

/*
 * 用户模块的action的类
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	// 注入UserService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	// 模型驱动使用的对象
	private User user=new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	// 接收验证码：
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	/*
	 * 跳转到注册页面的执行方法	
	 */
	public String registPage() {
		System.out.println("registPage");
		return "registPage";
		
	}
	/*
	 * Ajax进行异步校验用户名的执行方法
	 */
	public String findByUsername() throws IOException {
		// 调用service里面的方法
		User existUser =userService.findByUsername(user.getUsername());
		// 获得response对象，向页面输出：
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if(existUser!=null){
			// 查询到该用户：用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else{
			// 查询不到该用户：用户名不存在
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return null;
		
	}
	
	/*
	 * 用户注册的方法
	 */
	public String regist() {
		// 判断验证码程序：
		// 从session中获得验证码的随机的值
		String s_checkcode=(String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(s_checkcode)){
			this.addActionError("验证码输入错误！");
			return "checkcodeFail";
		}
		userService.regist(user);
		this.addActionMessage("注册成功！请去邮箱激活！");
		return "msg";
	}
	
	/*
	 * 用户激活的方法
	 */
	public String active(){
		// 根据激活码查询用户：
		System.out.println(user.getCode());
		User existUser=userService.findByCode(user.getCode());
		if(existUser==null ){
			// 激活码错误
			this.addActionMessage("激活失败：激活码错误！");
		}else{
			// 激活成功
			// 修改用户的状态
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功");
		}
		return "msg";	
	}
	/*
	 * 跳转到登录页面
	 */
	public String loginPage(){
		return "loginPage";
	}
	/*
	 * 用户登录的方法
	 */
	public String login(){
		// 调用service的方法
		User existUser=userService.login(user);
		// 判断
		if(existUser ==	null){
			// 登录失败
			this.addActionError("登录失败：用户名或密码错误或用户未激活！");
			return "login";
		}else{
			// 登录成功
			// 将用户信息存到session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			// 页面的跳转
			return "loginSuccess";
		}
	}
	/*
	 * 用户退出的方法
	 */
	public String quit(){
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
		
	}
}
