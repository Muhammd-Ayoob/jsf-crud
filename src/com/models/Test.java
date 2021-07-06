package com.models;

import java.util.List;

import com.dao.StudentDao;
import com.daoimpl.StudentDaoImpl;

public class Test {

	public static void main(String args[])
	{
		StudentDao dao=new StudentDaoImpl();
		
		List<StudentModel> list=dao.getAll();
		
		for(StudentModel sm:list)
		{
			System.out.println(sm.getStudentName()+"   "+sm.getRollNo());
		}
	}

}
