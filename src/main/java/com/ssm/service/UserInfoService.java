package com.ssm.service;

import javax.servlet.http.HttpServletRequest;

import com.ssm.model.LogMsg;

public interface UserInfoService
{

	public LogMsg UserInfoAllService(String username, String pwd);// ��ѯ�ͻ������������Ƿ���ȷ

	public LogMsg zhuceyhservice(HttpServletRequest request); // ע�����
}
