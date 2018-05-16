package org.yueball.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.yueball.service.IInfoService;
import org.yueball.service.IMatchService;
import org.yueball.util.Pager;
import org.yueball.vo.Ballmatch;
import org.yueball.vo.Touxiang;
import org.yueball.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InfoAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private Touxiang touxiang = new Touxiang();
	private IInfoService infoService;
	private IMatchService matchService;
	private int currentPage = 1;
	private File image;

	public String showUserInfo() {
		// infoService.showUserInfo(logname);
		// System.out.println(user.getSchool()); 输出null 只能通过session调用
		return SUCCESS;
	}

	public String updateUserInfo() {
		Map session = ActionContext.getContext().getSession();
		User user2 = (User) session.get("user");
		// System.out.println(user2.getLogname());
		// System.out.println(user.getPhone()+" "+user.getPhone()+"
		// "+user.getSchool()+" "+user.getLogname());
		user.setLogname(user2.getLogname());
		infoService.updateUserInfo(user.getPhone(), user.getQq(), user.getSchool(), user2.getLogname());
		session.put("user", user);
		return SUCCESS;
	}

	public String getMatchPagingByMatchId() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		int totalSize = infoService.getTotalMatchIdByUserInfo(user.getLogname());
		// System.out.println(totalSize);
		Pager originpager = new Pager(currentPage, totalSize);
		List matchIdList = infoService.getMatchIdByUserInfo(user.getLogname(), currentPage, originpager.getPageSize());
		if (matchIdList != null && matchIdList.size() != 0) {

			List<Ballmatch> matchList = new ArrayList<Ballmatch>();

			for (int i = 0; i < matchIdList.size(); i++) {
				matchList.add(matchService.getMatchById((int) matchIdList.get(i)));
			}

			Map request = (Map) ActionContext.getContext().get("request");
			request.put("originmatch", matchList);
			request.put("originpager", originpager);
		}
		return SUCCESS;
	}

	public String getJoinMatchPaging() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		int totalsize = infoService.getTotaJoinlMatchIdByUserInfo(user.getLogname());
		Pager joinpager = new Pager(currentPage, totalsize);
		List joinMatchList = infoService.getJoinMatchByUserInfo(user.getLogname(), currentPage,
				joinpager.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("joinmatch", joinMatchList);
		request.put("joinpager", joinpager);
		return SUCCESS;

	}

	public String loadTouxiang() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		touxiang.setTouxiangLogname(user.getLogname());
		infoService.loadInfoTx(touxiang, image);
		return SUCCESS;
	}

	public String showTouxiang() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		Touxiang touxiang = infoService.showInfoTx(user.getLogname());
		Blob txpic = touxiang.getTouxiangImage();
		ServletOutputStream sos = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/jpg");

		try {
			sos = response.getOutputStream();//通过该服务器输出流输出二进制信息
			byte[] b = txpic.getBytes(1, (int) txpic.length());
			sos.write(b);
			sos.flush();

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return null;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public IInfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(IInfoService infoService) {
		this.infoService = infoService;
	}

	public IMatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(IMatchService matchService) {
		this.matchService = matchService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

}
