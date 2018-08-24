package com.ssm.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.model.LogMsg;
import com.ssm.model.Student;
import com.ssm.model.UserInfo;
import com.ssm.service.UserInfoService;

@Controller
@RequestMapping("/UserInfoControl")
public class UserInfoController
{
	@Autowired /* �Զ�ע�룬�������� �� userinfoservice �Ϳ��Ե�����Ӧ�ĺ����ˣ���������Ҫnew UserInfoService�Ķ��� */
	private UserInfoService userinfoservice;

	/**
	 * ת���½ҳ
	 * 
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toLogin()
	{
		return "login";
	}

	/**
	 * 
	 * ��¼��ע��ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/zhuce")
	public String zhuce()
	{
		return "zhuce";// �û�ע��ҳ��
	}

	/**
	 * չʾ��½ҳ
	 * 
	 * @return
	 */
	@RequestMapping("/CheckUserInfo")
	@NotNull
	public String checkuserinfo(HttpServletRequest request, Model model)
	{
		LogMsg logmsg = new LogMsg();
		String name = request.getParameter("name");
		logmsg = userinfoservice.UserInfoAllService(name);
		if (!logmsg.getCode().equals("0"))
		{
			return "error";
		} else
		{
			return "welcome";
		}
	}

	/**
	 * ע���û����ݵ����ݿ�
	 * 
	 */
	@RequestMapping("/zhuceyh")
	@NotNull
	public String zhuceyh(HttpServletRequest request, Model model)
	{
		UserInfo userinfo = new UserInfo();
		String username = request.getParameter("name");
		String useriphoncode = request.getParameter("telephone");
		int iuseriphoncode = Integer.valueOf(useriphoncode);
		String pwd = request.getParameter("password");

		userinfo.setUsername(username);
		userinfo.setPwd(pwd);
		userinfo.setUseriphoncode(iuseriphoncode);

		userinfoservice.zhuceyhservice(userinfo);

		return null;
	}

}
