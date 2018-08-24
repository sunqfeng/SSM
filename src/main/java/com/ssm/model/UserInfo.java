package com.ssm.model;

import java.math.BigInteger;

public class UserInfo
{

	private String username;
	private String useriphoncode;
	private Integer usercode;
	private String pwd;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUseriphoncode()
	{
		return useriphoncode;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public void setUseriphoncode(String useriphoncode)
	{
		this.useriphoncode = useriphoncode;
	}

	public Integer getUsercode()
	{
		return usercode;
	}

	public void setUsercode(Integer usercode)
	{
		this.usercode = usercode;
	}

}
