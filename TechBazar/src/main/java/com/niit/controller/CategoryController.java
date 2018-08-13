package com.niit.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;
@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;

	
	@RequestMapping(value="/category")
	public String getCategoryPage(Model m)
	{
		Category category= new Category();
		m.addAttribute(category);
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categorylist",listCategories);
		
		return "Category";
	}
	
	@RequestMapping(value="InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("cname")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
	
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(category);
		Category category1= new Category();
		m.addAttribute(category1);
		m.addAttribute(category);
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categorylist",listCategories);
		
		return "Category";
	}
	
	@RequestMapping(value="deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		Category category1= new Category();
		m.addAttribute(category1);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categorylist",listCategories);
		return "Category";
		
	}
	
	@RequestMapping(value="editcategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		m.addAttribute(category);
		return "EditCategory";
	}
	
	@RequestMapping(value="updatecategory", method=RequestMethod.POST)
	public String updatecategory(@ModelAttribute("category")Category category,Model m)
	{
	
		categoryDAO.updateCategory(category);
		
		return "redirect:/category";
	}
}












