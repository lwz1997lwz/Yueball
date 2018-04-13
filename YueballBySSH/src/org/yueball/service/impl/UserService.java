package org.yueball.service.impl;

import org.yueball.dao.IUserDao;
import org.yueball.service.IUserService;
import org.yueball.vo.User;

public class UserService implements IUserService{

	 private IUserDao userdao;

	public User validate(String logname, String password) {
		// TODO Auto-generated method stub		
		return userdao.validate(logname, password);
	}
	public IUserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(IUserDao userdao) {
		this.userdao = userdao;
	}

}
