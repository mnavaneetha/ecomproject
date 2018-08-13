package com.niit.dao;


import java.util.List;

import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CartItem;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CartItem getCartItem(int cartId) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			CartItem cartItem=(CartItem)session.get(CartItem.class, cartId);
			return cartItem;
		}
		catch (Exception e)
		{
		return null;
	}
	}


	public boolean addCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}


	public boolean updateCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	
	public boolean deleteCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	
	public List<CartItem> listCartItems(String username) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from CartItem where username=:myusername and status=:'NA'");
			query.setParameter("myusername", username);
			List<CartItem> listCartItems=(List<CartItem>)query.getResultList();
			session.close();
			return listCartItems;
		}
		catch(Exception e)
		{
		return null;
	}

}
}
