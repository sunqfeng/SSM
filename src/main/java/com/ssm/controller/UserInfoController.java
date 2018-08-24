package com.ssm.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.model.Student;
import com.ssm.model.UserInfo;
import com.ssm.service.UserInfoService;

@Controller
@RequestMapping("/UserInfoControl")
public class UserInfoController
{
	@Autowired /* 自动注入，这样下面 的 userinfoservice 就可以调用相应的函数了，否则你需要new UserInfoService的对象 */
	private UserInfoService userinfoservice;

	/**
	 * 转向登陆页
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
	 * 登录到注册页面
	 * @return
	 */
	@RequestMapping("/zhuce")
	public String zhuce()
	{
		return "zhuce";//用户注册页面
	}

	/**
	 * 展示登陆页
	 * 
	 * @return
	 */
	@RequestMapping("/CheckUserInfo")
	@NotNull
	public String checkuserinfo(HttpServletRequest request, Model model)
	{
		String name = request.getParameter("name");
		List<UserInfo> userinfo = userinfoservice.UserInfoAllService(name);
		if (0 == userinfo.size() || null == userinfo)
		{
			return "error";
		}
		if (name.equals(userinfo.get(0).getUsername()))
		{
			return "welcome";
		} else
		{
			return "error";
		}
	}
	/**
	 * 注册用户数据到数据库
	 * 
	 */
	@RequestMapping("/zhuceyh")
	@NotNull
	public String zhuceyh(HttpServletRequest request, Model model)
	{
		UserInfo userinfo = new UserInfo();
		String username = request.getParameter("name");
		String useriphoncode = request.getParameter("telephone") ;
		int iuseriphoncode = Integer.valueOf(useriphoncode);
		String pwd = request.getParameter("password");

		userinfo.setUsername(username);
		userinfo.setPwd(pwd);
		userinfo.setUseriphoncode(iuseriphoncode);

		userinfoservice.zhuceyhservice(userinfo);

		return null;
	}
	


}
