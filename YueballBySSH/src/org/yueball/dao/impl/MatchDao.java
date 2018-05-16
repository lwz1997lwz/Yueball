package org.yueball.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.yueball.dao.BaseDao;
import org.yueball.dao.IMatchDao;
import org.yueball.vo.Ballmatch;

public class MatchDao extends BaseDao implements IMatchDao{

	@Override
	public void orginMatch(Ballmatch ballmatch,String mylogname,int match_id) {
		// TODO Auto-generated method stub
		String sql = "insert into myorigin values(?,?)";//往我的发起表中添加发起记录，便于以后查找我的发起记录
		Session session =getSession();
		Transaction tx= session.beginTransaction();//beginTransaction（）表示开启事务操作，getTrancation（）仅表示获得一个事物对象
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, mylogname);
		query.setParameter(1, match_id);
		query.executeUpdate();
		session.save(ballmatch);
		tx.commit();
		session.close();
	}

	@Override
	public List getMatchByType(String type) {//通过比赛类型，查找比赛
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
	/*
	 * 加入比赛 并将记录加入等待审核表  若审核成功后则加入我的加入表 并将目前人数加一
	 * 
	 **/
      public void joinMatch(String logname,int matchId,String matchOriginator) {
		Session session =getSession();
		Transaction tx= session.beginTransaction();		
		//String hql="update Ballmatch bm set bm.matchJoinnum=bm.matchJoinnum+1 where bm.matchId=?";
		//String hql2="insert into myjoin values(?,?)";
		String hql3="insert into checkmember(check_logname,checker,check_matchid) values(?,?,?)";
	    //Query query =session.createQuery(hql);
		//Query query2 =session.createSQLQuery(hql2);
		Query query3 =session.createSQLQuery(hql3);
		//query.setParameter(0, matchId);
		//query.executeUpdate();
		//query2.setParameter(0, logname);
		//query2.setParameter(1, matchId);
		//query2.executeUpdate();
		query3.setParameter(0, logname);
		query3.setParameter(1, matchOriginator);
		query3.setParameter(2, matchId);
		query3.executeUpdate();
		tx.commit();
		session.close();
	}

	@Override
	/*
	 * 分页显示筛选页面选出来的match
	 * 
	 * 	 */
	public List selectMatchPaging(String type, int limit, String difficulty, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from Ballmatch bm where bm.matchType=? and bm.matchDifficulty=? and bm.matchLimit <=?";
		Query query =session.createQuery(hql);
		query.setParameter(0, type);
		query.setParameter(1, difficulty);
		query.setParameter(2, limit);
		int startRow=(currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List matches=query.list();
		session.close(); 
		return matches;
	}

	@Override
	public int getTotalBySelect(String type, int limit, String difficulty) {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from Ballmatch bm where bm.matchType=? and bm.matchDifficulty=? and bm.matchLimit <=?";
		Query query =session.createQuery(hql);
		query.setParameter(0, type);
		query.setParameter(1, difficulty);
		query.setParameter(2, limit);
		List matches=query.list();
		session.close(); 
		return matches.size();
	}

	@Override
	public int getMaxMatchId() {
		// TODO Auto-generated method stub
		int i=0;
		Session session = getSession();
		Query query = session.createSQLQuery("select max(match_id) from ballmatch");
		System.out.println("i="+query.list().size());
		if((query.list().get(0)!=null)){
	     i=(int) (query.list().get(0));
		}
		//System.out.println(i);
		session.close();
		return i;
	}

	@Override
	public Ballmatch getMatchById(int matchId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql =" from Ballmatch bm where bm.matchId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, matchId);
		
		Ballmatch ballmatch = null;
		if(query.list()!=null&&query.list().size()!=0){
		 ballmatch=(Ballmatch) (query.list().get(0));
		}
		session.close();
		return ballmatch;
	}

	@Override
	public void agreeJoin(String logname, int matchId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql="update Ballmatch bm set bm.matchJoinnum=bm.matchJoinnum+1 where bm.matchId=?";
		String hql2="insert into myjoin values(?,?)";
		Query query =session.createQuery(hql);
		Query query2 =session.createSQLQuery(hql2);
		query.setParameter(0, matchId);
	    query.executeUpdate();//执行更新时需要增加事务处理
		query2.setParameter(0, logname);
		query2.setParameter(1, matchId);
		query2.executeUpdate();
		session.close();
	}
      
}
