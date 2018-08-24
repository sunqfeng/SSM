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


	@Autowired /* �Զ�ע�룬����userinfo�Ϳ��Ե��� class UserInfoDao����Ӧ�ĺ��� ,����new UserInfoDao */
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
		int maxusercode = userinfodao.max_usercode_userinfo();//�����Ա��id��
		userinfo.setUsercode(maxusercode+1);
		userinfodao.zhuceyh(userinfo);//�����userinfo
	}


}
