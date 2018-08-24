package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.Student;

public interface StudentDao
{

	/**
	 * 查询所有结果student
	 * 
	 * @param <Student>
	 * @
	 * 
	 */
	List<Student> StudentAll(); /* StudentAll()函数与mapping中xml里面的ID对应着 */

	/*
	 * 保存数据到student
	 */
	void SaveStudent(Student student);

	/**
	 * 使用注解方式传入多个参数，用户产品分页，通过登录用户ID查询
	 * 
	 * @param page
	 * @param userId
	 * @return startPos},#{pageSize}
	 */
	public List<Student> selectStudentByPage(@Param(value = "startPos") Integer startPos,
			@Param(value = "pageSize") Integer pageSize);

	public int getStudentCount();

}
