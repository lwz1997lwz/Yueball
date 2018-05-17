package org.yueball.service.impl;

import java.util.List;

import org.yueball.dao.IMatchDao;
import org.yueball.service.IMatchService;
import org.yueball.vo.Ballmatch;

public class MatchService implements IMatchService{
    IMatchDao matchDao;
	@Override
	public void orginMatch(Ballmatch ballmatch,String mylogname,int match_id) {
		// TODO Auto-generated method stub
		matchDao.orginMatch(ballmatch ,mylogname, match_id);
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
	@Override
	public void joinMatch(String logname,int matchId,String matchOriginator) {
		// TODO Auto-generated method stub
		matchDao.joinMatch(logname,matchId,matchOriginator);
	}
	@Override
	public List selectMatchPaging(String type, int limit, String difficulty, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return matchDao.selectMatchPaging(type, limit, difficulty, currentPage, pageSize);
	}
	@Override
	public int getTotalBySelect(String type, int limit, String difficulty) {
		// TODO Auto-generated method stub
		return matchDao.getTotalBySelect(type, limit, difficulty);
	}
	@Override
	public Ballmatch getMatchById(int matchId) {
		// TODO Auto-generated method stub
		return matchDao.getMatchById(matchId);
	}
	@Override
	public void agreeJoin(String logname, int matchId) {
		// TODO Auto-generated method stub
		matchDao.agreeJoin(logname, matchId);
	}
	public IMatchDao getMatchDao() {
		return matchDao;
	}
	public void setMatchDao(IMatchDao matchDao) {
		this.matchDao = matchDao;
	}
	@Override
	public int getMaxMatchId() {
		// TODO Auto-generated method stub
		return matchDao.getMaxMatchId();
	}
	
	
}
