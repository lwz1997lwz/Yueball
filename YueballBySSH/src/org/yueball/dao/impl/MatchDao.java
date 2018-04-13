package org.yueball.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.yueball.dao.BaseDao;
import org.yueball.dao.IMatchDao;
import org.yueball.vo.Ballmatch;

public class MatchDao extends BaseDao implements IMatchDao{

	@Override
	public void orginMatch(Ballmatch ballmatch) {
		// TODO Auto-generated method stub
		Session session =getSession();
		Transaction tx= session.beginTransaction();//beginTransaction（）表示开启事务操作，getTrancation（）仅表示获得一个事物对象
		session.save(ballmatch);
		tx.commit();
		session.close();
	}

	@Override
	public List getMatchByType(String type) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from Ballmatch bm where bm.matchType=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, type);
		List matches= query.list();
		session.close();
		return matches;
	}

	@Override
	public List getMatchPaging(String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from Ballmatch bm where bm.matchType=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, type);
		int startRow=(currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List matches= query.list();
		session.close();
		return matches;
	}

}
