package com.niit.dao;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean registerUserDetail(UserDetail userDetail) 
	{
		try{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
		
   }

	public boolean updateUserDetail(UserDetail userDetail)
	{
		try
		{
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
		
	}

	public UserDetail getUserDetail(String username)
	{
	  try
		{
			Session session=sessionFactory.getCurrentSession();
			UserDetail userDetail=(UserDetail)session.get(UserDetail.class,username);
			return userDetail;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

}
