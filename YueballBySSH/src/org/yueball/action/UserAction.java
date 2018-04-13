package org.yueball.action;

import java.util.Map;

import org.yueball.service.IUserService;
import org.yueball.service.impl.UserService;
import org.yueball.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	  private User user =new User(); //ʹ��ModelDriven�ӿڣ����������ݽ��з�װ  �����ֶ�new����Ȼ�ͳ��ֿ�ָ���쳣
      protected IUserService userService;
	  
      public String login() {  //�м�action�еķ������ܴ����� �����Ҳ����÷���
		  User u=userService.validate(user.getLogname(),user.getPassword());
		  System.out.println(user.getLogname()+" "+user.getPassword());
			if(u!=null)
			{
				Map session=ActionContext.getContext().getSession();
				//����˴λỰ��u���û��˺ţ���Ϣ
				session.put("user",u);
				return SUCCESS;
			}
			return ERROR;
	}
	  
	  public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}


   
	
}
