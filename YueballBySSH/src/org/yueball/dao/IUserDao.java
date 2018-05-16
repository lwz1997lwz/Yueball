package org.yueball.dao;

import org.yueball.vo.User;

public interface IUserDao {

	public User validate(String logname,String password);
	public void saveUser(User user) ;//注册用户
	public boolean existUser(String logname);//用于dwr框架中验证该用户名是否已经被注册
}
