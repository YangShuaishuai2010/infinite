package yss.shop.order.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yss.shop.order.entity.Order;
import yss.shop.order.entity.OrderItem;
import yss.shop.order.service.OrderService;
import yss.shop.utils.PageBean;
/*
 * 后台订单管理的action
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	// 注入订单管理的service
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	// 模型驱动使用的对象
	private Order order = new Order();
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	// 接受currentPage参数
	private Integer currentPage;
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	// 带分页查询订单的执行的方法
	public String findAll(){
		// 分页查询
		PageBean<Order> pageBean = orderService.findByPage(currentPage);
		// 通过值栈保存数据到页面：
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findAll";
	}
	
	// 根据订单oid查询订单项：
	public String findOrderItem(){
		// 根据订单oid查询订单项
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		// 通过值栈保存数据到页面：
		ActionContext.getContext().getValueStack().set("list", list);
		// 页面跳转
		return "findOrderItem";
	}
	
	// 后台修改订单状态的方法：
	public String updateState(){
		// 1 根据订单的oid查询订单
		Order currOrder = orderService.findByOid(order.getOid());
		// 2 修改订单状态
		currOrder.setState(3);
		orderService.update(currOrder);
		// 3 页面跳转
		return "updateStateSuccess";
	}
	
}
