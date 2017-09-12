package yss.shop.categorysecond.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yss.shop.category.entity.Category;
import yss.shop.category.service.CategoryService;
import yss.shop.categorysecond.entity.CategorySecond;
import yss.shop.categorysecond.service.CategorySecondService;
import yss.shop.utils.PageBean;

/*
 * 后台二级分类管理的action
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	// 注入二级分类的Service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	// 注入一级分类的Service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	// 模型驱动使用的对象
	private CategorySecond categorySecond = new CategorySecond();
	@Override
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return categorySecond;
	}
	// 接收currentPage
	private Integer currentPage;
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	// 查询二级分类的方法
	public String findAll(){
		// 调用service
		PageBean<CategorySecond> pageBean = categorySecondService.findByPage(currentPage);
		// 将pageBean的数据保存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findAll";	
	}
	// 跳转到添加页面
	public String addPage(){
		// 查询所有的一级分类：
		List<Category> cList = categoryService.findAll();
		// 把数据显示到页面的下拉列表中：
		ActionContext.getContext().getValueStack().set("cList", cList);
		// 页面跳转
		return "addPageSuccess";	
	}
	// 保存二级分类的方法
	public String save(){
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	// 删除二级分类的方法
	public String delete(){
		// 如果要级联删除，先查询在删除，配置cascade
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";	
	}
	// 编辑二级分类的方法
	public String edit(){
		// 根据二级分类的csid查询二级分类的对象：
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		// 查询所有的一级分类
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}
	// 修改二级分类的方法：
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}

}
