package com.ssm.service;

import java.util.List;

import com.ssm.model.LogMsg;
import com.ssm.model.UserInfo;

public interface UserInfoService
{

	public LogMsg UserInfoAllService(String username,String pwd);//��ѯ�ͻ������������Ƿ���ȷ

	public LogMsg zhuceyhservice(UserInfo userinfo); //ע�����
}
