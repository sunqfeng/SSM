package com.ssm.model;

/************************************************
 * 
 * 定义报文结构体 code为0表示程序正确,否则程序错误,msg表示日志消息
 * 
 * @author sunqifeng
 *
 ************************************************/
public class LogMsg
{

	String msg;
	String code;

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

}
