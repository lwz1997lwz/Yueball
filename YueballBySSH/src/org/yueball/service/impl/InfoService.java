package org.yueball.service.impl;

import java.io.File;
import java.util.List;

import org.yueball.dao.IInfoDao;
import org.yueball.service.IInfoService;
import org.yueball.vo.Checkmember;
import org.yueball.vo.Touxiang;
import org.yueball.vo.User;

public class InfoService implements IInfoService {
    IInfoDao infoDao;
	@Override
	public User showUserInfo(String logname) {
		// TODO Auto-generated method stub
		return infoDao.showUserInfo(logname);
	}
	@Override
	public void updateUserInfo(String phone, String qq, String school, String logname) {
		// TODO Auto-generated method stub
		infoDao.updateUserInfo(phone, qq, school,logname);
	}
	
	@Override
	public List getMatchIdByUserInfo(String logname,int currentPage,int pageSize) {
		// TODO Auto-generated method stub
		return infoDao.getMatchIdByUserInfo(logname,currentPage,pageSize);
	}
	@Override
	public int getTotalMatchIdByUserInfo(String logname) {
		// TODO Auto-generated method stub
		return infoDao.getTotalMatchIdByUserInfo(logname);
	}
	@Override
	public List getJoinMatchByUserInfo(String logname, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return infoDao.getJoinMatchByUserInfo(logname, currentPage, pageSize);
	}
	@Override
	public int getTotaJoinlMatchIdByUserInfo(String logname) {
		// TODO Auto-generated method stub
		return infoDao.getTotaJoinlMatchIdByUserInfo(logname);
	}
	@Override
	public List<Checkmember> getCheckMemberPaging(String logname,int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return infoDao.getCheckMemberPaging(logname,currentPage,pageSize);
	}
	@Override
	public int getTotalCheckMember(String logname) {
		// TODO Auto-generated method stub
		return infoDao.getTotalCheckMember(logname);
	}
	
	public void loadInfoTx(Touxiang touxiang,File image){
	     infoDao.loadInfoTx(touxiang, image);
	}
	public Touxiang showInfoTx(String logname){
		return infoDao.showInfoTx(logname);
	}
	public IInfoDao getInfoDao() {
		return infoDao;
	}
	public void setInfoDao(IInfoDao infoDao) {
		this.infoDao = infoDao;
	}
	
	
}
