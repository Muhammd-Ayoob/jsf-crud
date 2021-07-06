package com.dao;

import java.util.List;

import com.models.StudentModel;

public interface StudentDao {
	public void addStudent(StudentModel student);
	
	public List<StudentModel> getAll();
	
	public void delete(StudentModel student);
	
	public StudentModel getById(int id);
	
	public void update(StudentModel student);
}
