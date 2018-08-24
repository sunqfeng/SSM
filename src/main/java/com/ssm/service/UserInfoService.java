package com.ssm.service;

import java.util.List;

import com.ssm.model.LogMsg;
import com.ssm.model.UserInfo;

public interface UserInfoService
{

	public LogMsg UserInfoAllService(String username,String pwd);//查询客户姓名、密码是否正确

	public LogMsg zhuceyhservice(UserInfo userinfo); //注册操作
}
