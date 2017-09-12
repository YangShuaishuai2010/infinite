package yss.shop.user.service;
import org.springframework.transaction.annotation.Transactional;
import yss.shop.user.entity.User;
import yss.shop.utils.MailUtils;
import yss.shop.utils.UUIDUtils;
import yss.shop.user.dao.UserDao;

/*
 * 用户模块业务逻辑层的代码：
 */
@Transactional
public class UserService {
	// 注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	// 按用户名查询用户的方法：
	public User findByUsername(String username){
		return (User) userDao.findByUsername(username);
	}
	// 业务层完成用户注册的代码：
	public void regist(User user) {
		// TODO Auto-generated method stub
		// 将数据存入到数据库
		user.setState(0);// 0代表用户未激活。 1代表用户激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();//一个32位，弄两个 共64位
		user.setCode(code);// 设置进激活码
		userDao.regist(user);
		// 发送激活邮件
		MailUtils.sendMail(user.getEmail(), code);
	}
	// 业务层根据激活码查询用户
	public User findByCode(String code) {
		// TODO Auto-generated method stub
		return userDao.findByCode(code);
	}
	// 修改用户的状态的方法
	public void update(User existUser) {
		// TODO Auto-generated method stub
		userDao.update(existUser);
		
	}
	// 用户登录的方法
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
