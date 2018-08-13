
package com.niit.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.UserDetail;

public class DBConfigTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		ProductDAO	productDAO=(ProductDAO)context.getBean("productDAO");
		UserDAO	userDAO=(UserDAO)context.getBean("userDAO");
		CartDAO	cartDAO=(CartDAO)context.getBean("cartDAO");
		
		Category category=new Category();
		category.setCategoryName("Mobile");
		category.setCategoryDesc("Samsung Mobiles");
		
		categoryDAO.addCategory(category);
		
		System.out.println("Category Object Saved:");

		UserDetail userDetail=new UserDetail();
		userDetail.setAddress("chennai");
		userDetail.setCustomerName("navaneetha");
		userDetail.setEmail("navaneetha@gmail.com");
		userDetail.setMobile("124567890");
		userDetail.setPassword("123");
		userDetail.setRole("ROLE_USER");
		userDetail.setUsername("navaneetha123");
		userDetail.setEnabled(true);
		
		
		userDAO.registerUserDetail(userDetail);
		
		System.out.println("user Object Saved:");
	}
}

