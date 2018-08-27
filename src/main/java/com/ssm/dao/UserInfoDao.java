package com.ssm.dao;

import com.ssm.model.*;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/***********************************************************
 * Dao����Ҫ�Ƕ���mybatis��com.ssm.mapping UserInfoMapper.xml�ĺ���
 *
 *
 ***********************************************************/

public interface UserInfoDao
{

	/* ��Ӧ��Mabatis ��Mapper.xml �е�id=UserInfoAll */
	public List<UserInfo> UserInfoAll(@Param(value = "username") String username);

	public void zhuceyh(UserInfo userinfo);

	public int max_usercode_userinfo();

	public int sel_count_userinfo(String username);//���ظ��û��������ݿ��е�����

	//mybatis���ж����������ʱ��Ҫ��@Paramע��,��Ȼmybatis����ʶ��
	public List<UserInfo> sel_userinfo_fy(@Param(value = "startPos")Integer startPos,@Param(value = "pageSize")  Integer pageSize ); //��ҳ��ѯuserinfo��Ϣ

	public int getalluserinfo();//��ѯ��userinfo������������


}
