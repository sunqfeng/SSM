package com.ssm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ssm.model.Student;

public interface StudentService
{

	/**
	 * ���巵������student��Ϣ
	 * 
	 * @return
	 */
	List<Student> loadStudent();

	/**
	 * ����student������Ϣ
	 * 
	 * @param student
	 */
	public void SaveStudent(Student student);

	/**
	 * �����ҳ��ѯ��student��ӿ�
	 * 
	 */
	public void ServiceShowStudentByPage(HttpServletRequest request, Model model);

}
