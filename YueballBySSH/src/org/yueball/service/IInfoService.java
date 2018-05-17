package org.yueball.service;

import java.io.File;
import java.util.List;

import org.yueball.vo.Checkmember;
import org.yueball.vo.Touxiang;
import org.yueball.vo.User;

public interface IInfoService {
	public User showUserInfo(String logname);
	public void updateUserInfo(String phone,String qq,String school,String logname);
	public List getMatchIdByUserInfo(String logname,int currentPage,int pageSize);
	public int getTotalMatchIdByUserInfo(String logname);
	public List getJoinMatchByUserInfo(String logname, int currentPage, int pageSize);
	public int getTotaJoinlMatchIdByUserInfo(String logname);
	public void loadInfoTx(Touxiang touxiang,File image);
	public Touxiang showInfoTx(String logname);
	public List<Checkmember> getCheckMemberPaging(String logname,int currentPage, int pageSize);
	public int getTotalCheckMember(String logname);
	
	
}
