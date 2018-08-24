package com.ssm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssm.dao.UserInfoDao;
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

	@Override
	public List<UserInfo> UserInfoAllService(String username)
	{
		// TODO Auto-generated method stub
		return userinfodao.UserInfoAll(username);
	}

	@Override
	public void zhuceyhservice(UserInfo userinfo)
	{
		// TODO Auto-generated method stub
		int maxusercode = userinfodao.max_usercode_userinfo();//求最大员工id号
		userinfo.setUsercode(maxusercode+1);
		userinfodao.zhuceyh(userinfo);//插入表userinfo
	}


}
