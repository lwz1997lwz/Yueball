package org.yueball.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.yueball.dao.BaseDao;
import org.yueball.dao.IUserDao;
import org.yueball.vo.User;

public class UserDao  extends BaseDao implements IUserDao{

	@Override
	public User validate(String logname, String password) {
		// TODO Auto-generated method stub
		String hql="from User u where u.logname=? and u.password=?";
		
		Session session =getSession();
		Query query =session.createQuery(hql);
		query.setParameter(0, logname);
		query.setParameter(1, password);
		System.out.println(hql);
		List users =query.list();
		if(users.size()!=0){
			User  user = (User)users.get(0);
		      return user;
		}
		
		    session.close();
			return null;		
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Override
	public boolean existUser(String logname) {
		// TODO Auto-generated method stub
		 String hql="from User u where u.logname=?";
		  Session session=getSession();
		  Query query=session.createQuery(hql);
		  query.setParameter(0, logname);
		  List  users=query.list();
			if(users.size()!=0){
				return true;
				}
			session.close();
			return false;
		}
	}


