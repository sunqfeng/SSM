package com.ssm.model;

public class UserInfo
{

	private String username;
	private Integer useriphoncode;
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

	public Integer getUseriphoncode()
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

	public void setUseriphoncode(Integer useriphoncode)
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
