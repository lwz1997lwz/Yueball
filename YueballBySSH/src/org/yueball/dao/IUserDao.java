package org.yueball.dao;

import org.yueball.vo.User;

public interface IUserDao {

	public User validate(String logname,String password);
	public void saveUser(User user) ;//ע���û�
	public boolean existUser(String logname);//����dwr�������֤���û����Ƿ��Ѿ���ע��
}
