package yss.shop.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yss.shop.category.entity.Category;
import yss.shop.category.service.CategoryService;
/*
 * 后台一级分类管理的action
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	// 注入一级分类的service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	// 模型驱动使用的对象
	private Category category = new Category();
	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	// 后台执行查询所有一级分类的方法
	public String findAll(){
		// 查询所有一级分类
		List<Category> cList = categoryService.findAll();
		// 将集合显示到页面上去：
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	// 后台保存一级分类的方法：
	public String save(){
		// 调用service进行保存
		categoryService.save(category);
		// 页面的跳转：
		return "saveSuccess";
	}
	// 后台删除一级分类的方法：
	public String delete(){
		// 接收cid，可以使用模型驱动，删除一级分类，同时删除二级分类，必须先根据id查询 ，再进行删除
		category = categoryService.findByCid(category.getCid());
		// 删除：
		categoryService.delete(category);
		// 页面的跳转：
		return "deleteSuccess";
	}
	// 后台编辑一级分类的方法
	public String edit(){
		// 根据一级分类的管理 查询一级分类
		category = categoryService.findByCid(category.getCid());
		// 页面的跳转
		return "editSuccess";
	}
	// 后台修改一级分类的方法
	public String update(){
		categoryService.update(category);
		// 页面的跳转
		return "updateSuccess";
	}
	

}
