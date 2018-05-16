package org.yueball.action;

import java.io.ByteArrayInputStream;
import java.util.Map;
import org.yueball.service.IUserService;
import org.yueball.util.VerifyCode;
import org.yueball.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User(); // 使用ModelDriven接口，对请求数据进行封装
									// 必须手动new，不然就出现空指针异常
	private String code;
	protected IUserService userService;
	private ByteArrayInputStream inputStream;

	public String login() { // 切记action中的方法不能带参数 否则找不到该方法
		User u = userService.validate(user.getLogname(), user.getPassword());
		System.out.println(user.getLogname() + " " + user.getPassword());
		Map session = ActionContext.getContext().getSession();
		boolean flag = true;// 用于判断验证码输入的正确性
		if (code.equals((String) session.get("codeValue"))) {
			flag = true;

		}
		System.out.println(user.getSchool());
		if ((u != null) && (flag == true)) {
			// 保存此次会话的u（用户账号）信息
			session.put("user", u);
			return SUCCESS;
		}
		return ERROR;
	}

	/*
	 * 生成验证码,并将其置于session中
	 * 
	 */
	public String getImage() throws Exception {
		VerifyCode verifyCode = VerifyCode.Instance();
		this.inputStream = verifyCode.getImage(); // 将图片存于图片流中
		ActionContext.getContext().getSession() // 将验证码的字符串形式存与session中，用于登录验证
				.put("codeValue", verifyCode.getVerificationCodeValue());
		// HttpServletResponse response = ServletActionContext.getResponse();
		// PrintWriter out = response.getWriter();
		// out.printf("imageCodeValue",verifyCode.getVerificationCodeValue());
		return SUCCESS;
	}
    public String registerUser() {
    	userService.saveUser(user);
		return SUCCESS;
	}
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
