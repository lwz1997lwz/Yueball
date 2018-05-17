	package org.yueball.dao.impl;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.List;
	
	import org.hibernate.Query;
	import org.hibernate.SQLQuery;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import org.yueball.dao.BaseDao;
	import org.yueball.dao.IInfoDao;
	import org.yueball.vo.Ballmatch;
	import org.yueball.vo.Checkmember;
	import org.yueball.vo.Touxiang;
	import org.yueball.vo.User;
	
	import com.mysql.jdbc.Blob;
	
	public class InfoDao extends BaseDao implements IInfoDao{
	    IInfoDao infoDao;
		@Override
		public User showUserInfo(String logname) {
			// TODO Auto-generated method stub
			Session session =getSession();
			String hql="from User u where u.logname = ? ";
			Query query =session.createQuery(hql);
			query.setParameter(0, logname);
			List user = query.list();
			session.close();
			return  (User)user.get(0);
		}
		@Override
		public void updateUserInfo(String phone, String qq, String school ,String logname) {
			// TODO Auto-generated method stub
			Session session =getSession();
			String sql = "update user set Phone = ?,QQ = ? , school = ? where logname=?";//使用sql语句更新
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, phone);
			query.setParameter(1, qq);
			query.setParameter(2, school);
			query.setParameter(3, logname);
			query.executeUpdate();
			session.close();
		}
	
		@Override
		public List getMatchIdByUserInfo(String logname,int currentPage,int pageSize) {
			// TODO Auto-generated method stub
			Session session = getSession();
			String sql = "select match_id from myorigin where mylogname = ?";
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, logname);
			query.setFirstResult((currentPage-1)*pageSize);
			query.setMaxResults(pageSize);
			List matchIdList=query.list();
			session.close();
			return matchIdList;
		}
		@Override
		public List getJoinMatchByUserInfo(String logname, int currentPage, int pageSize) {
			// TODO Auto-generated method stub
			Session session = getSession();
			//String sql = "select b.match_id,match_originator,b.match_mess,b.match_joinnum,b.match_limit,b.match_date,b.match_type,b.match_difficulty,b.match_address from ballmatch as b,myjoin as my where b.match_id = my.match_id and my.mylogname=?";
			String sql = "select b.* from ballmatch as b,myjoin as my where b.match_id = my.match_id and my.mylogname=?";
			SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(Ballmatch.class);//必须是所有属性
			sqlQuery.setParameter(0, logname);
			sqlQuery.setFirstResult((currentPage-1)*pageSize);
			sqlQuery.setMaxResults(pageSize);
			List joinMatchList=sqlQuery.list();
			System.out.println("joinmatch:"+joinMatchList.size());
			session.close();
			return joinMatchList;
		}
		/*
		 * 获取该用户发起的所有比赛id的总数 用于分页
		 * 
		 */
		@Override
		public int getTotalMatchIdByUserInfo(String logname) {
			// TODO Auto-generated method stub
			Session session = getSession();
			String sql = "select match_id from myorigin where mylogname = ?";
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, logname);
			int total=query.list().size();
			session.close();
			return total;
		}
		/*
		 * 获取该用户参加的所有比赛id的总数 用于分页
		 * 
		 */
		public int getTotaJoinlMatchIdByUserInfo(String logname) {
			// TODO Auto-generated method stub
			Session session = getSession();
			String sql = "select match_id from myjoin where mylogname = ?";
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, logname);
			int total=query.list().size();
			session.close();
			return total;
		}
		@Override
		public void loadInfoTx(Touxiang touxiang,File image) {
			// TODO Auto-generated method stub
	        Session session = getSession();
	        Transaction tx=session.beginTransaction();
	        String sql="delete from touxiang where touxiang_logname=?"; 
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setParameter(0, touxiang.getTouxiangLogname());
	        query.executeUpdate();
	        try {
				FileInputStream in = new FileInputStream(image);
				byte b[] = new byte[in.available()];
				in.read(b);
				java.sql.Blob pic = session.getLobHelper().createBlob(b);
				//或者直接通过将流转换成blob对象
				//session.getLobHelper().createBlob(in, in.available());
				
				touxiang.setTouxiangImage(pic);
				session.save(touxiang);
				tx.commit();
				session.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
		@Override
		public Touxiang showInfoTx(String logname) {
			// TODO Auto-generated method stub
			Session session = getSession();
			String sql= "from Touxiang tx where tx.touxiangLogname=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, logname);
			List touxianglist = query.list();
			session.close();  
			  if(touxianglist!=null||touxianglist.size()>0)
			      return (Touxiang) touxianglist.get(0);
			  else
				  return null;
		}
		@Override
		public List<Checkmember> getCheckMemberPaging(String logname,int currentPage, int pageSize) {
			// TODO Auto-generated method stub
			Session session = getSession();
			String sql="from Checkmember cm where cm.checker=?";
			Query query  = session.createQuery(sql);
			query.setFirstResult((currentPage-1)*pageSize);
			query.setMaxResults(pageSize);
			query.setParameter(0, logname);
			List checkMemberList= query.list();
			session.close(); 
			if(checkMemberList!=null&&checkMemberList.size()!=0)
			    return checkMemberList;
			
			else {
				//System.out.println("这是null");			
				return null;
			}
			
		}
		@Override
		public int getTotalCheckMember(String logname) {
			Session session = getSession();
			String sql="from Checkmember cm where cm.checker=?";
			Query query  = session.createQuery(sql);
			query.setParameter(0, logname);
			List checkMemberList= query.list();
			session.close(); 
			if(checkMemberList!=null&&checkMemberList.size()!=0)
			    return checkMemberList.size();
			else {
				return 0 ;
			}
		}
		
	
	}
