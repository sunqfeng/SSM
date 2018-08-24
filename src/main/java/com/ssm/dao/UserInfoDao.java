package com.ssm.dao;

import com.ssm.model.*;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/***********************************************************
 * Dao层主要是定义mybatis中com.ssm.mapping UserInfoMapper.xml的函数
 *
 *
 ***********************************************************/

public interface UserInfoDao
{

	/* 对应着Mabatis 中Mapper.xml 中的id=UserInfoAll */
	public List<UserInfo> UserInfoAll(@Param(value = "username") String username);

	public void zhuceyh(UserInfo userinfo);

	public int max_usercode_userinfo();

}
