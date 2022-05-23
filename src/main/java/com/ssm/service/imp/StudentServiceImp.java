package com.ssm.service.imp;

/*
 * 2022年5月23日21:01:04.
 * sqf 新增一个简单的注解.
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

		String pageNow = request.getParameter("pageNow");/* 获取当前页 */

		Page page = null;/* 分页工具类 */

		/* 声明一个链表 */
		List<Student> studentlist = new ArrayList<Student>();

		int totalCount = studentdao.getStudentCount();/* 获取student所有记录的条数 */

		if (pageNow != null)
		{
			page = new Page(totalCount, Integer.parseInt(pageNow));
			/* 将查询出来的分页结果放入链表数组中 */
			studentlist = this.studentdao.selectStudentByPage(page.getStartPos(), page.getPageSize());
		} else
		{
			page = new Page(totalCount, 1);
			/* 将查询出来的分页结果放入链表数组中 */
			studentlist = this.studentdao.selectStudentByPage(page.getStartPos(), page.getPageSize());
		}
		/* 通过service 将结果放在model */
		model.addAttribute("student", studentlist);
		model.addAttribute("page", page);
	}
}
