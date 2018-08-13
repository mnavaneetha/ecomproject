package com.niit.test;

	import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Product;
import com.niit.model.UserDetail;

	public class ProductDAOTestCase 
	{

		static ProductDAO productDAO;
		static UserDAO userDAO;
		
		@BeforeClass
		public static void executeFirst()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			
			productDAO=(ProductDAO)context.getBean("productDAO");
			userDAO=(UserDAO)context.getBean("userDAO");
			}

		@Test
		@Ignore
		public void addProductTestCase()
		{
			Product product=new Product();
			product.setProductName("Samsung J7");
			product.setProductDesc("Samsung Mobile with 4G Features");
			product.setPrice(12000);
			product.setStock(20);
			product.setCategoryId(1);
			product.setSupplierId(1);
			
			assertTrue("Problem in Adding Product",productDAO.addProduct(product));
		}
		@Test
	
		public void adduser()
		{
			UserDetail userdetail=new UserDetail();
			userdetail.setAddress("chennai");
			userdetail.setCustomerName("navaneetha");
			userdetail.setEmail("navaneetha@gmail.com");
			userdetail.setMobile("124567890");
			userdetail.setPassword("123");
			userdetail.setRole("ROLE_USER");
			userdetail.setUsername("navaneetha123");
			userdetail.setEnabled(true);
			
			
			assertTrue("Problem in Adding user"+userdetail,userDAO.registerUserDetail(userdetail));
		}
		
	}


