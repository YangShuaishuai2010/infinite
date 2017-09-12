package yss.shop.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yss.shop.category.entity.Category;
import yss.shop.category.service.CategoryService;
import yss.shop.product.entity.Product;
import yss.shop.product.service.ProductService;
import yss.shop.utils.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	// 注入ProductService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	// 接收一级分类的cid
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	// 接收当前页数currentPage
	private int currentPage;
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	// 接收二级分类的csid
	private Integer csid;
	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	// 注入一级分类的service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	private Product product=new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	// 根据商品的pid查询商品
	public String findByPid(){
		// 调用Service的方法完成查询
		product =productService.findByPid(product.getPid());
		return "findByPid";
	}
	
	// 根据一级分类的cid查询商品
	public String findByCid(){
		List<Category> cList=categoryService.findAll();
		// 将一级分类存入到session的范围
		ActionContext.getContext().getSession().put("cList", cList);
		PageBean<Product> pageBean=productService.findByPageCid(cid,currentPage);//根据一级分类查询商品，并带分页。
		// 将PageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	
	// 根据二级分类的csid查询商品
	public String findByCsid(){
		// 调用service查询
		PageBean<Product> pageBean=productService.findByPageCsid(csid,currentPage);
		// 将PageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
		
	}
}
