package org.yueball.dao;

import java.util.List;

import org.yueball.vo.Ballmatch;

public interface IMatchDao {
    public void orginMatch(Ballmatch ballmatch);
    public List getMatchByType(String type);
    public List getMatchPaging(String type,int currentPage,int pageSize);
}
