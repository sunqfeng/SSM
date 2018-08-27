package com.ssm.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ssm.dao.UserInfoDao;
import com.ssm.model.LogMsg;
import com.ssm.model.Student;
import com.ssm.model.UserInfo;
import com.ssm.service.UserInfoService;
import com.ssm.util.Page;

@Component
public class UserInfoServiceImp implements UserInfoService
{

	@Autowired /* 自动注入，这样userinfo就可以调用 class UserInfoDao的相应的函数 ,不用new UserInfoDao */
	private UserInfoDao userinfodao;

	public UserInfoDao getUserinfo()
	{
		return userinfodao;
	}

	public void setUserinfo(UserInfoDao userinfo)
	{
		this.userinfodao = userinfo;
	}

	/**
	 * 检查客户登录的用户名，密码是否正确
	 * 
	 */
	@SuppressWarnings("null")
	@Override
	public LogMsg UserInfoAllService(String username, String pwd)
	{
		// TODO Auto-generated method stub
		List<UserInfo> userinfo = new ArrayList<UserInfo>();
		LogMsg logmsg = new LogMsg();

		userinfo = userinfodao.UserInfoAll(username);
		if ((userinfo != null && !userinfo.isEmpty())
				&& (userinfo.get(0).getUsername().equals(username) && userinfo.get(0).getPwd().equals(pwd))) // 判断用户以及密码是否正确
		{
			logmsg.setCode("0");
		} else
		{
			logmsg.setCode("1101");
			logmsg.setMsg("用户不存在或密码错误");
		}
		return logmsg;
	}

	/**
	 * 处理客户注册函数(插入表userinfo)
	 * 
	 * @user sqf
	 * @param userinfo
	 * @return
	 */
	@Override
	public LogMsg zhuceyhservice(HttpServletRequest request)
	{
		// TODO Auto-generated method stub
		UserInfo userinfo = new UserInfo();
		LogMsg logmsg = new LogMsg();
		int maxusercode = userinfodao.max_usercode_userinfo();// 求最大员工id号

		userinfo.setUseriphoncode(request.getParameter("telephone"));
		userinfo.setPwd(request.getParameter("password"));
		userinfo.setUsername(request.getParameter("name"));

		//判断该用户名是否已经重复
		int Count = userinfodao.sel_count_userinfo(request.getParameter("name"));
		if( Count>0 )
		{
			logmsg.setCode("1103");
			logmsg.setMsg("该用户已经注册,请选择用户名");
			return logmsg;
		}

		//开始进行插入操作
		userinfo.setUsercode(maxusercode + 1);
		userinfodao.zhuceyh(userinfo);// 插入表userinfo
		logmsg = UserInfoAllService(userinfo.getUsername(), userinfo.getPwd()); // 判断是否插入成功

		return logmsg;
	}

	public void Showuserinfofy(HttpServletRequest request, Model model)
	{
		// TODO Auto-generated method stub

		String pageNow = request.getParameter("pageNow");/* 获取当前页 */

		Page page = null;/* 分页工具类 */

		/* 声明一个链表 */
		List<UserInfo> userinfolist = new ArrayList<UserInfo>();

		int totalCount = userinfodao.getalluserinfo();/* 获取userinfo所有记录的条数 */

		if (pageNow != null)
		{
			page = new Page(totalCount, Integer.parseInt(pageNow));
			/* 将查询出来的分页结果放入链表数组中 */
			userinfolist = this.userinfodao.sel_userinfo_fy(page.getStartPos(), page.getPageSize());
		} else
		{
			page = new Page(totalCount, 1);
			/* 将查询出来的分页结果放入链表数组中 */
			userinfolist = this.userinfodao.sel_userinfo_fy(page.getStartPos(), page.getPageSize());
		}
		/* 通过service 将结果放在model */
		model.addAttribute("userinfo", userinfolist);
		model.addAttribute("page", page);
	}



}
