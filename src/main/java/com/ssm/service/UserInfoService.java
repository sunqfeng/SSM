package com.ssm.service;

import java.util.List;

import com.ssm.model.UserInfo;

public interface UserInfoService
{

	public List<UserInfo> UserInfoAllService(String username);
	public void zhuceyhservice(UserInfo userinfo);
}
