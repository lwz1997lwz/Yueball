package org.yueball.dao;

import java.io.File;
import java.sql.Blob;
import java.util.List;

import org.yueball.vo.Checkmember;
import org.yueball.vo.Touxiang;
import org.yueball.vo.User;

public interface IInfoDao {
  public User showUserInfo(String logname);
  public void updateUserInfo(String phone,String qq,String school,String logname);
  public List getMatchIdByUserInfo(String logname,int currentPage,int pageSize);//·ÖÒ³
  public List getJoinMatchByUserInfo(String logname,int currentPage,int pageSize);//·ÖÒ³
  public int getTotalMatchIdByUserInfo(String logname);
  public int getTotaJoinlMatchIdByUserInfo(String logname);
  public int getTotalCheckMember(String logname);
  public void loadInfoTx(Touxiang touxiang,File image);
  public Touxiang showInfoTx(String logname);
  public List<Checkmember> getCheckMemberPaging(String logname,int currentPage, int pageSize);
  
}
