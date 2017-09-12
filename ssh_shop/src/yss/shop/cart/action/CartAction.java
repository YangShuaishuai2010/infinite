package yss.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import yss.shop.cart.entity.Cart;
import yss.shop.cart.entity.CartItem;
import yss.shop.product.entity.Product;
/*
 * 购物车的Action
 */
import yss.shop.product.service.ProductService;
public class CartAction extends ActionSupport {
	// 注入商品的service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 接收pid
	private Integer pid;
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	// 接收数量count
	private Integer count;
	public void setCount(Integer count) {
		this.count = count;
	}


	// 将购物项添加到购物车：执行的方法
	public String addCart(){
		System.out.println(count+":::count:::::pid:::::"+pid);
		// 封装一个CartItem对象
		CartItem cartItem = new CartItem();
		// 设置数量
		cartItem.setCount(count);
		// 根据pid进行商品的查询：
		Product product = productService.findByPid(pid);
		// 设置商品
		cartItem.setProduct(product);
		// 将购物项添加到购物车：
		// 购物车应该存在session中
		Cart cart = getCart();
		cart.addCart(cartItem);
		
		return "addCart";
		
	}
	
	// 清空购物车的执行的方法
	public String clearCart(){
		// 获得购物车的对象
		Cart cart = getCart();
		// 调用购物车中的清空方法
		cart.clearCart();
		return "clearCart";
	}
	
	// 从购物车中移除购物项的方法
	public String removeCart(){
		// 获得购物车的对象
		Cart cart = getCart();
		// 调用购物车中的移除的方法
		cart.removeCart(pid);
		// 返回页面：
		
		return "removeCart";
		
	}
	
	// 跳转到我得购物车的方法
	public String myCart() {
		return "myCart";
	}
	
	// 获得购物车的方法：从session中获得购物车
	private Cart getCart() {
		// TODO Auto-generated method stub
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}

}
