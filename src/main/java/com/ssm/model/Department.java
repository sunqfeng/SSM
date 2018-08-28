package com.ssm.model;

public class Department
{
	String Name;
	String ParentName; 
	String Level; //¼¶±ð
	String Desc; //ÃèÊö

	public String getName()
	{
		return Name;
	}
	public void setName(String name)
	{
		Name = name;
	}
	public String getParentName()
	{
		return ParentName;
	}
	public void setParentName(String parentName)
	{
		ParentName = parentName;
	}
	public String getLevel()
	{
		return Level;
	}
	public void setLevel(String level)
	{
		Level = level;
	}
	public String getDesc()
	{
		return Desc;
	}
	public void setDesc(String desc)
	{
		Desc = desc;
	}

}
