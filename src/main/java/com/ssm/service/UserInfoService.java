package com.ssm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ssm.model.LogMsg;

public interface UserInfoService
{

	public LogMsg UserInfoAllService(String username, String pwd);// 查询客户姓名、密码是否正确

	public LogMsg zhuceyhservice(HttpServletRequest request); // 注册操作

	public void Showuserinfofy(HttpServletRequest request, Model model);//分页显示userinfo表的信息
}
