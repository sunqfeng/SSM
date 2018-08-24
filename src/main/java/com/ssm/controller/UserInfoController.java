package com.ssm.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.model.LogMsg;
import com.ssm.model.UserInfo;
import com.ssm.service.UserInfoService;

/*****************************************************
* 
* 该文件中的所有函数主要控制页面之间跳转，逻辑处理判断尽量放在service
* 层进行处理 
* @author sunqifeng
*
*****************************************************/

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
	 * 
	 * @return
	 */
	@RequestMapping("/zhuce")
	public String zhuce()
	{
		return "zhuce";// 用户注册页面
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
		LogMsg logmsg = new LogMsg();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		logmsg = userinfoservice.UserInfoAllService(name,pwd);//判断客户用户名，密码是否正确
		model.addAttribute("logmsg", logmsg);
		if (!logmsg.getCode().equals("0"))
		{
//			return "error";
			return "login";
		} 
		else
		{
			return "welcome";
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
		LogMsg logmsg = new LogMsg();

		String username = request.getParameter("name");
		String useriphoncode = request.getParameter("telephone");
		String pwd = request.getParameter("password");

		logmsg = userinfoservice.zhuceyhservice(request);//注册操作(姓名、密码插入表userinfo)
		if( !logmsg.getCode().equals("0") )
		{
			return "error";//注册失败则跳转到error界面
		}
		else
		{
			return "login"; //注册成功后直接跳转到登录界面
		}
	}

}
