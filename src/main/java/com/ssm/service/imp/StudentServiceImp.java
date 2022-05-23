package com.ssm.service.imp;

/*
 * 2022��5��23��21:01:04.
 * sqf ����һ���򵥵�ע��.
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ssm.model.Student;
import com.ssm.service.StudentService;
import com.ssm.util.Page;
import com.alibaba.druid.stat.TableStat.Mode;
import com.ssm.dao.StudentDao;

@Component
public class StudentServiceImp implements StudentService
{

	@Autowired
	private StudentDao studentdao;

	public StudentDao getStudentdao()
	{
		return studentdao;
	}

	public void setStudentdao(StudentDao studentdao)
	{
		this.studentdao = studentdao;
	}

	@Override
	public List<Student> loadStudent()
	{

		return studentdao.StudentAll();
	}

	@Override
	public void SaveStudent(Student student)
	{
		// TODO Auto-generated method stub
		studentdao.SaveStudent(student);
	}

	@Override
	public void ServiceShowStudentByPage(HttpServletRequest request, Model model)
	{
		// TODO Auto-generated method stub

		String pageNow = request.getParameter("pageNow");/* ��ȡ��ǰҳ */

		Page page = null;/* ��ҳ������ */

		/* ����һ������ */
		List<Student> studentlist = new ArrayList<Student>();

		int totalCount = studentdao.getStudentCount();/* ��ȡstudent���м�¼������ */

		if (pageNow != null)
		{
			page = new Page(totalCount, Integer.parseInt(pageNow));
			/* ����ѯ�����ķ�ҳ����������������� */
			studentlist = this.studentdao.selectStudentByPage(page.getStartPos(), page.getPageSize());
		} else
		{
			page = new Page(totalCount, 1);
			/* ����ѯ�����ķ�ҳ����������������� */
			studentlist = this.studentdao.selectStudentByPage(page.getStartPos(), page.getPageSize());
		}
		/* ͨ��service ���������model */
		model.addAttribute("student", studentlist);
		model.addAttribute("page", page);
	}
}
