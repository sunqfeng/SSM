package com.ssm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ssm.model.LogMsg;

public interface UserInfoService
{

	public LogMsg UserInfoAllService(String username, String pwd);// ��ѯ�ͻ������������Ƿ���ȷ

	public LogMsg zhuceyhservice(HttpServletRequest request); // ע�����

	public void Showuserinfofy(HttpServletRequest request, Model model);//��ҳ��ʾuserinfo�����Ϣ
}
