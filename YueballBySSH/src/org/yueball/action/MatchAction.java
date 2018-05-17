package org.yueball.action;

import java.util.List;
import java.util.Map;


import org.yueball.service.IMatchService;
import org.yueball.util.Pager;
import org.yueball.vo.Ballmatch;
import org.yueball.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MatchAction extends ActionSupport implements ModelDriven<Ballmatch>{
   private User user;
   private Ballmatch ballmatch=new Ballmatch();
   private int currentPage=1;
   protected IMatchService matchService;
	public String orginMatch() {
		
		Map  session =ActionContext.getContext().getSession();
		if(session.get("user")!=null){		
		   matchService.orginMatch(ballmatch,((User)session.get("user")).getLogname(),matchService.getMaxMatchId()+1);			
			return SUCCESS;
		}	
			return ERROR;		
	}
	public String getMatchPaging() {
		//System.out.println(ballmatch.getMatchType());
		int totalSize=matchService.getMatchByType(ballmatch.getMatchType()).size();
		Pager pager =new Pager(currentPage, totalSize);
		List match= matchService.getMatchPaging(ballmatch.getMatchType(), currentPage, pager.getPageSize());
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("match", match);	
		request.put("pager",pager);
		return SUCCESS;
	}
	public String selectMatchPaging() {
		int totalSize=matchService.getTotalBySelect(ballmatch.getMatchType(), ballmatch.getMatchLimit(), ballmatch.getMatchDifficulty());
		System.out.println(ballmatch.getMatchLimit());
		Pager pager =new Pager(currentPage, totalSize);
		List  match=matchService.selectMatchPaging(ballmatch.getMatchType(), ballmatch.getMatchLimit(), ballmatch.getMatchDifficulty(), currentPage, pager.getPageSize());
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("match", match);	
		request.put("pager",pager);
		return SUCCESS;
	}

	public String joinMatch(){
	
		//System.out.println("发起者是："+ballmatch.getMatchOriginator());
		Map  session =ActionContext.getContext().getSession();
		matchService.joinMatch(((User)session.get("user")).getLogname(),ballmatch.getMatchId(),ballmatch.getMatchOriginator());
		return SUCCESS;		
	}
	public String agreeJoin() {
		Map  session =ActionContext.getContext().getSession();
		matchService.agreeJoin(((User)session.get("user")).getLogname(), ballmatch.getMatchId());
		return SUCCESS;
	}
	public IMatchService getMatchService() {
		return matchService;
	}
	public void setMatchService(IMatchService matchService) {
		this.matchService = matchService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Ballmatch getBallmatch() {
		return ballmatch;
	}

	public void setBallmatch(Ballmatch ballmatch) {
		this.ballmatch = ballmatch;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public Ballmatch getModel() {
		// TODO Auto-generated method stub
		return ballmatch;
	}
	
	
}
