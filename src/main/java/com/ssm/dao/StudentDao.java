package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.Student;

public interface StudentDao
{

	/**
	 * ��ѯ���н��student
	 * 
	 * @param <Student>
	 * @
	 * 
	 */
	List<Student> StudentAll(); /* StudentAll()������mapping��xml�����ID��Ӧ�� */

	/*
	 * �������ݵ�student
	 */
	void SaveStudent(Student student);

	/**
	 * ʹ��ע�ⷽʽ�������������û���Ʒ��ҳ��ͨ����¼�û�ID��ѯ
	 * 
	 * @param page
	 * @param userId
	 * @return startPos},#{pageSize}
	 */
	public List<Student> selectStudentByPage(@Param(value = "startPos") Integer startPos,
			@Param(value = "pageSize") Integer pageSize);

	public int getStudentCount();

}
