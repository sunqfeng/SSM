package com.ssm.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ssm.dao.UserInfoDao;
import com.ssm.model.LogMsg;
import com.ssm.model.Student;
import com.ssm.model.UserInfo;
import com.ssm.service.UserInfoService;
import com.ssm.util.Page;

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

	/**
	 * ���ͻ���¼���û����������Ƿ���ȷ
	 * 
	 */
	@SuppressWarnings("null")
	@Override
	public LogMsg UserInfoAllService(String username, String pwd)
	{
		// TODO Auto-generated method stub
		List<UserInfo> userinfo = new ArrayList<UserInfo>();
		LogMsg logmsg = new LogMsg();

		userinfo = userinfodao.UserInfoAll(username);
		if ((userinfo != null && !userinfo.isEmpty())
				&& (userinfo.get(0).getUsername().equals(username) && userinfo.get(0).getPwd().equals(pwd))) // �ж��û��Լ������Ƿ���ȷ
		{
			logmsg.setCode("0");
		} else
		{
			logmsg.setCode("1101");
			logmsg.setMsg("�û������ڻ��������");
		}
		return logmsg;
	}

	/**
	 * ����ͻ�ע�ắ��(�����userinfo)
	 * 
	 * @user sqf
	 * @param userinfo
	 * @return
	 */
	@Override
	public LogMsg zhuceyhservice(HttpServletRequest request)
	{
		// TODO Auto-generated method stub
		UserInfo userinfo = new UserInfo();
		LogMsg logmsg = new LogMsg();
		int maxusercode = userinfodao.max_usercode_userinfo();// �����Ա��id��

		userinfo.setUseriphoncode(request.getParameter("telephone"));
		userinfo.setPwd(request.getParameter("password"));
		userinfo.setUsername(request.getParameter("name"));

		//�жϸ��û����Ƿ��Ѿ��ظ�
		int Count = userinfodao.sel_count_userinfo(request.getParameter("name"));
		if( Count>0 )
		{
			logmsg.setCode("1103");
			logmsg.setMsg("���û��Ѿ�ע��,��ѡ���û���");
			return logmsg;
		}

		//��ʼ���в������
		userinfo.setUsercode(maxusercode + 1);
		userinfodao.zhuceyh(userinfo);// �����userinfo
		logmsg = UserInfoAllService(userinfo.getUsername(), userinfo.getPwd()); // �ж��Ƿ����ɹ�

		return logmsg;
	}

	public void Showuserinfofy(HttpServletRequest request, Model model)
	{
		// TODO Auto-generated method stub

		String pageNow = request.getParameter("pageNow");/* ��ȡ��ǰҳ */

		Page page = null;/* ��ҳ������ */

		/* ����һ������ */
		List<UserInfo> userinfolist = new ArrayList<UserInfo>();

		int totalCount = userinfodao.getalluserinfo();/* ��ȡuserinfo���м�¼������ */

		if (pageNow != null)
		{
			page = new Page(totalCount, Integer.parseInt(pageNow));
			/* ����ѯ�����ķ�ҳ����������������� */
			userinfolist = this.userinfodao.sel_userinfo_fy(page.getStartPos(), page.getPageSize());
		} else
		{
			page = new Page(totalCount, 1);
			/* ����ѯ�����ķ�ҳ����������������� */
			userinfolist = this.userinfodao.sel_userinfo_fy(page.getStartPos(), page.getPageSize());
		}
		/* ͨ��service ���������model */
		model.addAttribute("userinfo", userinfolist);
		model.addAttribute("page", page);
	}



}
