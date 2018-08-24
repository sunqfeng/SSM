package com.ssm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ssm.model.Student;

public interface StudentService
{

	/**
	 * 定义返回所有student信息
	 * 
	 * @return
	 */
	List<Student> loadStudent();

	/**
	 * 插入student表中信息
	 * 
	 * @param student
	 */
	public void SaveStudent(Student student);

	/**
	 * 定义分页查询的student表接口
	 * 
	 */
	public void ServiceShowStudentByPage(HttpServletRequest request, Model model);

}
