package org.yueball.dao;

import java.util.List;

import org.yueball.vo.Ballmatch;

public interface IMatchDao {
    public void orginMatch(Ballmatch ballmatch,String mylogname,int match_id);
    public List getMatchByType(String type);
    public Ballmatch getMatchById(int matchId);
    public List getMatchPaging(String type,int currentPage,int pageSize);
    public void joinMatch(String logname,int matchId,String matchOriginator);//������ѡ��������ʱ���ڸñ�����Ŀǰ������+1
    public List selectMatchPaging(String type,int limit,String difficulty,int currentPage,int pageSize);
    public int getTotalBySelect(String type,int limit,String difficulty);
    public int getMaxMatchId();
    public void agreeJoin(String logname,int matchId);
}
