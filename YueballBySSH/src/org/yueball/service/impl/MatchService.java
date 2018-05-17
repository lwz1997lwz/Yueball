package org.yueball.service.impl;

import java.util.List;

import org.yueball.dao.IMatchDao;
import org.yueball.service.IMatchService;
import org.yueball.vo.Ballmatch;

public class MatchService implements IMatchService{
    IMatchDao matchDao;
	@Override
	public void orginMatch(Ballmatch ballmatch) {
		// TODO Auto-generated method stub
		matchDao.orginMatch(ballmatch);
	}
	@Override
	public List getMatchByType(String type) {
		// TODO Auto-generated method stub
		
		return matchDao.getMatchByType(type);
	}
	@Override
	public List getMatchPaging(String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		
		return matchDao.getMatchPaging(type, currentPage, pageSize);
	}
	public IMatchDao getMatchDao() {
		return matchDao;
	}
	public void setMatchDao(IMatchDao matchDao) {
		this.matchDao = matchDao;
	}
	


}
