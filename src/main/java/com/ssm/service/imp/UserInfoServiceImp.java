package com.ssm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssm.dao.UserInfoDao;
import com.ssm.model.LogMsg;
import com.ssm.model.UserInfo;
import com.ssm.service.UserInfoService;

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
	public LogMsg UserInfoAllService(String username,String pwd)
	{
		// TODO Auto-generated method stub
		List<UserInfo> userinfo = new ArrayList<UserInfo>();
		LogMsg logmsg = new LogMsg();

		userinfo = userinfodao.UserInfoAll(username);
		if( (userinfo !=null && !userinfo.isEmpty()) && 
			(userinfo.get(0).getUsername().equals(username) && userinfo.get(0).getPwd().equals(pwd))) //判断用户以及密码是否正确
		{
			logmsg.setCode("0");
		}
		else
		{
			logmsg.setCode("1101");
			logmsg.setMsg("用户不存在或密码错误");
		}
		return logmsg;
	}

	/**
	 * 处理客户注册函数(插入表userinfo)
	 * @param userinfo
	 * @return 
	 */
	@Override
	public LogMsg zhuceyhservice(UserInfo userinfo)
	{
		// TODO Auto-generated method stub
		LogMsg logmsg = new LogMsg();
		int maxusercode = userinfodao.max_usercode_userinfo();// 求最大员工id号
		userinfo.setUsercode(maxusercode + 1);
		userinfodao.zhuceyh(userinfo);// 插入表userinfo
		logmsg = UserInfoAllService(userinfo.getUsername(),userinfo.getPwd()); //判断是否插入成功
		return logmsg ;
	}

}
