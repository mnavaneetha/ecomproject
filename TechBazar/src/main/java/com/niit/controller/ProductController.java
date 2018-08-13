package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;


@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="manageproduct")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute(product);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("productList",productDAO.listProducts());
		
		return "ManageProduct";
	}
	
	@RequestMapping("/productDisplay")
	public String displayAllProducts(Model m)
	{
		Product product=new Product();
		m.addAttribute(product);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("productList",productDAO.listProducts());
		return "ProductDisplay";
	}
	
	@RequestMapping("totalproduct/{productId}")
	public String totalproduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		m.addAttribute("product",product);
		return "TotalProduct";
	}

	@RequestMapping(value="/ProductInsert",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile imageFile,Model m)
	{
		productDAO.addProduct(product);
		m.addAttribute("categoryList",this.getCategories());
		
		Product product1=new Product();
		m.addAttribute(product1);
		
	    String path="C:\\Users\\home\\workspace\\nitt.mavenprojects\\TechBazar\\src\\main\\webapp\\resources\\images\\";
	    path=path+String.valueOf(product.getProductId())+".jpg";
	    
	    File file=new File(path);
	    
	    
		if(!imageFile.isEmpty())
	    {
	    	try
	    	{
	    		byte[] buffer=imageFile.getBytes();
	    		FileOutputStream fos=new FileOutputStream(file);
	    		BufferedOutputStream bs=new BufferedOutputStream(fos);
	    		bs.write(buffer);
	    		bs.close();
	    	}
	    	catch(Exception e)
	    	{
	    	   System.out.println("Exception Arrised:"+e);	
	    	}
	    }
	    	else
	    	{
	    		m.addAttribute("ErrorInfo","There is System Problem No Image Insertion");
	    	}
	    
		
		
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("productList",productDAO.listProducts());
		return "ManageProduct";
	}
	
	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		LinkedHashMap<Integer,String> categoryData=new LinkedHashMap<Integer,String>();
		for(Category category:listCategories)
		{
			categoryData.put(category.getCategoryId(),category.getCategoryName());
		}
		return categoryData;
	}
	

	@RequestMapping(value="deleteproduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute(product1);
		m.addAttribute("categorylist", this.getCategories());
		m.addAttribute("productlist",productDAO.listProducts());
		
		return "Product";
	}
	@RequestMapping(value="editproduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute(product);
		m.addAttribute("categorylist", this.getCategories());
		return "EditProduct";
	}
	@RequestMapping(value="updateproduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model m)
	{
		System.out.println("product controller update product");
		productDAO.updateProduct(product);
	
		System.out.println("after commeting the binding code");
		return "redirect:/product";
	}
}













