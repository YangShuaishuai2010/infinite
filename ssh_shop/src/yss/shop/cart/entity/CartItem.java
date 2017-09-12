package yss.shop.cart.entity;

import yss.shop.product.entity.Product;

/*
 * 购物项对象
 */
public class CartItem {
	private Product product;//购物项中商品的信息
	private int count;		//购买的某种商品的数量
	private double subtotal;//购买的某种商品的小计
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	// 小计是自动计算出来的
	public double getSubtotal() {
		return count*product.getShop_price();
	}
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}*/
	

}
