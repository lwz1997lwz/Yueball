package org.yueball.service;

import org.yueball.vo.User;

public interface IUserService {
   public User validate(String logname,String password);
   public void saveUser(User user);
   public boolean existUser(String logname);
}
