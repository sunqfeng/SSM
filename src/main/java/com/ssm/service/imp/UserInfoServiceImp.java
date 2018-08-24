package com.ssm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssm.dao.UserInfoDao;
import com.ssm.model.LogMsg;
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

	/**
	 * ���ͻ���¼���û����������Ƿ���ȷ
	 * 
	 */
	@SuppressWarnings("null")
	@Override
	public LogMsg UserInfoAllService(String username,String pwd)
	{
		// TODO Auto-generated method stub
		List<UserInfo> userinfo = new ArrayList<UserInfo>();
		LogMsg logmsg = new LogMsg();

		userinfo = userinfodao.UserInfoAll(username);
		if( (userinfo !=null && !userinfo.isEmpty()) && 
			(userinfo.get(0).getUsername().equals(username) && userinfo.get(0).getPwd().equals(pwd))) //�ж��û��Լ������Ƿ���ȷ
		{
			logmsg.setCode("0");
		}
		else
		{
			logmsg.setCode("1101");
			logmsg.setMsg("�û������ڻ��������");
		}
		return logmsg;
	}

	/**
	 * ����ͻ�ע�ắ��(�����userinfo)
	 * @param userinfo
	 * @return 
	 */
	@Override
	public LogMsg zhuceyhservice(UserInfo userinfo)
	{
		// TODO Auto-generated method stub
		LogMsg logmsg = new LogMsg();
		int maxusercode = userinfodao.max_usercode_userinfo();// �����Ա��id��
		userinfo.setUsercode(maxusercode + 1);
		userinfodao.zhuceyh(userinfo);// �����userinfo
		logmsg = UserInfoAllService(userinfo.getUsername(),userinfo.getPwd()); //�ж��Ƿ����ɹ�
		return logmsg ;
	}

}
