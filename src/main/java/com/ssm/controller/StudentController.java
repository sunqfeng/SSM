package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.model.*;
import com.ssm.service.*;

@Controller
@RequestMapping("/studentControl") /* ҳ�����������������studentcontrol�����֡� */
public class StudentController
{
	@Autowired

	private StudentService studentservice;

	/**
	 * 
	 * 
	 * �ӵ�ע��
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/ShowStudent")
	public String showPersons(Model model)
	{
		List<Student> student = studentservice.loadStudent();
		model.addAttribute("student", student);
		return "showstudent";

	}

	/**
	 * ��ת��addstudentҳ��
	 * 
	 */
	@RequestMapping("/ToAddStudent")
	public String toaddstudent()
	{
		return "AddStudent";
	}

	/***
	 * ���student��Ϣ
	 * 
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping("/AddStudent")
	public String SaveStudent(Student student, Model model)
	{
		studentservice.SaveStudent(student);
		List<Student> studentlist = studentservice.loadStudent();
		model.addAttribute("student", studentlist);
		return "showstudent";
	}

	@RequestMapping("/ShoweStudentByPage")
	public String ShowStudentByStudent(HttpServletRequest request, Model model)
	{
		studentservice.ServiceShowStudentByPage(request, model);
		return "studentbypage";
	}

}
