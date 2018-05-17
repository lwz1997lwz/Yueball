package org.yueball.dao;

import org.yueball.vo.User;

public interface IUserDao {

	public User validate(String logname,String password);
}
