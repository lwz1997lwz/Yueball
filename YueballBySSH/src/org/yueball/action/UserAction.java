package org.yueball.action;

import java.util.Map;

import org.yueball.service.IUserService;
import org.yueball.service.impl.UserService;
import org.yueball.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	  private User user =new User(); //使用ModelDriven接口，对请求数据进行封装  必须手动new，不然就出现空指针异常
      protected IUserService userService;
	  
      public String login() {  //切记action中的方法不能带参数 否则找不到该方法
		  User u=userService.validate(user.getLogname(),user.getPassword());
		  System.out.println(user.getLogname()+" "+user.getPassword());
			if(u!=null)
			{
				Map session=ActionContext.getContext().getSession();
				//保存此次会话的u（用户账号）信息
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
