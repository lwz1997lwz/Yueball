package org.yueball.service;

import java.util.List;

import org.yueball.vo.Ballmatch;

public interface IMatchService {
	public void orginMatch(Ballmatch ballmatch,String mylogname,int match_id);
	public List  getMatchByType(String type);
	public List getMatchPaging(String type,int currentPage,int pageSize);
	public void joinMatch(String logname,int matchId,String matchOriginator);
	public List selectMatchPaging(String type,int limit,String difficulty,int currentPage,int pageSize);
	public int getTotalBySelect(String type,int limit,String difficulty);
	public int getMaxMatchId();
	public Ballmatch getMatchById(int matchId);
	public void agreeJoin(String logname,int matchId);
}
