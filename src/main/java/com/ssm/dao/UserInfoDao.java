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

	public int sel_count_userinfo(String username);//返回该用户名在数据库中的数量

	//mybatis中有多个参数传入时需要加@Param注入,不然mybatis不能识别
	public List<UserInfo> sel_userinfo_fy(@Param(value = "startPos")Integer startPos,@Param(value = "pageSize")  Integer pageSize ); //分页查询userinfo信息

	public int getalluserinfo();//查询表userinfo共多少条数据


}
