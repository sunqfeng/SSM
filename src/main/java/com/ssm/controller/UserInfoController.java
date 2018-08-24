package com.ssm.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.model.LogMsg;
import com.ssm.model.UserInfo;
import com.ssm.service.UserInfoService;

/*****************************************************
* 
* ���ļ��е����к�����Ҫ����ҳ��֮����ת���߼������жϾ�������service
* ����д��� 
* @author sunqifeng
*
*****************************************************/

@Controller
@RequestMapping("/UserInfoControl")
public class UserInfoController
{
	@Autowired /* �Զ�ע�룬�������� �� userinfoservice �Ϳ��Ե�����Ӧ�ĺ����ˣ���������Ҫnew UserInfoService�Ķ��� */
	private UserInfoService userinfoservice;
	/**
	 * ת���½ҳ
	 * 
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toLogin()
	{
		return "login";
	}

	/**
	 * 
	 * ��¼��ע��ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/zhuce")
	public String zhuce()
	{
		return "zhuce";// �û�ע��ҳ��
	}

	/**
	 * չʾ��½ҳ
	 * 
	 * @return
	 */
	@RequestMapping("/CheckUserInfo")
	@NotNull
	public String checkuserinfo(HttpServletRequest request, Model model)
	{
		LogMsg logmsg = new LogMsg();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		logmsg = userinfoservice.UserInfoAllService(name,pwd);//�жϿͻ��û����������Ƿ���ȷ
		model.addAttribute("logmsg", logmsg);
		if (!logmsg.getCode().equals("0"))
		{
//			return "error";
			return "login";
		} 
		else
		{
			return "welcome";
		}
	}

	/**
	 * ע���û����ݵ����ݿ�
	 * 
	 */
	@RequestMapping("/zhuceyh")
	@NotNull
	public String zhuceyh(HttpServletRequest request, Model model)
	{
		LogMsg logmsg = new LogMsg();

		String username = request.getParameter("name");
		String useriphoncode = request.getParameter("telephone");
		String pwd = request.getParameter("password");

		logmsg = userinfoservice.zhuceyhservice(request);//ע�����(��������������userinfo)
		if( !logmsg.getCode().equals("0") )
		{
			return "error";//ע��ʧ������ת��error����
		}
		else
		{
			return "login"; //ע��ɹ���ֱ����ת����¼����
		}
	}

}
