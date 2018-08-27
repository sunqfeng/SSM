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
@RequestMapping("/studentControl") /* 页面的请求就是这个‘（studentcontrol）名字’ */
public class StudentController
{
	@Autowired

	private StudentService studentservice;

	/**
	 * 
	 * 
	 * 加点注解
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
	 * 跳转到addstudent页面
	 * 
	 */
	@RequestMapping("/ToAddStudent")
	public String toaddstudent()
	{
		return "AddStudent";
	}

	/***
	 * 添加student信息
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
