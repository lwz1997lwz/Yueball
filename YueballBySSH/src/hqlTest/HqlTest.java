package hqlTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yueball.vo.Ballmatch;
import org.yueball.vo.Myorigin;
import org.yueball.vo.User;

public class HqlTest{
	
	@Test
	public void originTest2() {
		ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory=(SessionFactory) con.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
     	Ballmatch ballmatch =new Ballmatch();
     	ballmatch.setMatchAddress("111");
		ballmatch.setMatchDate("111");
	
		Myorigin myorigin3= new Myorigin();
	    myorigin3.setMylogname("zm6");
		myorigin3.setMatchId(2);
		//ballmatch.setMyorigin(myorigin3);
		myorigin3.getBallmatchs().add(ballmatch);
		
	    Transaction tx= session.beginTransaction();//beginTransaction（）表示开启事务操作，getTrancation（）仅表示获得一个事物对象
		session.save(myorigin3);
	//	session.save(ballmatch);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	public void originTest() {
		ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory=(SessionFactory) con.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
//		Ballmatch ballmatch =new Ballmatch();
//     	ballmatch.setMatchAddress("111");
//		ballmatch.setMatchDate("111");
//		
//		Myorigin myorigin= new Myorigin();
//		myorigin.setMylogname("lwz");
//		myorigin.setMatchId(1);
//		ballmatch.setMyorigin(myorigin);
	//	myorigin.getBallmatchs().add(ballmatch);
		
	    Transaction tx= session.beginTransaction();//beginTransaction（）表示开启事务操作，getTrancation（）仅表示获得一个事物对象
		User user =(User)session.get(User.class, 1);
		 System.out.println(user.getLogname()+" "+user.getPassword());
		tx.commit();
		session.close();
		 sessionFactory.close();
	}
}
