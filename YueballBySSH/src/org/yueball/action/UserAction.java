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
	private User user = new User(); // ʹ��ModelDriven�ӿڣ����������ݽ��з�װ
									// �����ֶ�new����Ȼ�ͳ��ֿ�ָ���쳣
	private String code;
	protected IUserService userService;
	private ByteArrayInputStream inputStream;

	public String login() { // �м�action�еķ������ܴ����� �����Ҳ����÷���
		User u = userService.validate(user.getLogname(), user.getPassword());
		System.out.println(user.getLogname() + " " + user.getPassword());
		Map session = ActionContext.getContext().getSession();
		boolean flag = true;// �����ж���֤���������ȷ��
		if (code.equals((String) session.get("codeValue"))) {
			flag = true;

		}
		System.out.println(user.getSchool());
		if ((u != null) && (flag == true)) {
			// ����˴λỰ��u���û��˺ţ���Ϣ
			session.put("user", u);
			return SUCCESS;
		}
		return ERROR;
	}

	/*
	 * ������֤��,����������session��
	 * 
	 */
	public String getImage() throws Exception {
		VerifyCode verifyCode = VerifyCode.Instance();
		this.inputStream = verifyCode.getImage(); // ��ͼƬ����ͼƬ����
		ActionContext.getContext().getSession() // ����֤����ַ�����ʽ����session�У����ڵ�¼��֤
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
