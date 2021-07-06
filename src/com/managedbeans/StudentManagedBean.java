package com.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.dao.StudentDao;
import com.daoimpl.StudentDaoImpl;
import com.models.StudentModel;

@ManagedBean(name="studentMB")
@RequestScoped
@PersistenceContext
@PersistenceUnit
public class StudentManagedBean {

StudentDao dao=new StudentDaoImpl();


public static Integer stId;
	
private Integer studentId;
	
	private String studentName;
	
	private String gmail;
	
	private String contact;
	
	private String rollNo;
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	private String department;
	
	private String gender;

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the gmail
	 */
	public String getGmail() {
		return gmail;
	}

	/**
	 * @param gmail the gmail to set
	 */
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public String addStudent()
	{
		StudentModel student=new StudentModel();
		
		student.setStudentName(studentName);
		
		student.setRollNo(rollNo);
		
		student.setGmail(gmail);
		
		student.setContact(contact);
		
		student.setDepartment(department);
		
		student.setGender(gender);
		
		
		
		dao.addStudent(student);
	
		
		return "";
	}
	
	
	public List<StudentModel> students()
	{
		List<StudentModel> list=dao.getAll();
		
		return list;
	}
	
	public String delete(Integer id)
	{		
		StudentModel student=dao.getById(id);
		
		dao.delete(student);
		System.out.println("IAM DELETE METHOD");
		return "";
	}
	
	public String show()
	{
		System.out.println("Iam show method!!!!");
		return "";
	}
	
	
	public String update(Integer id)
	{
		StudentModel model=dao.getById(id);
		
		
		System.out.println("MODEL ID = "+model.getStudentId());
		studentId=model.getStudentId();
		
		stId=studentId;
		
		studentName=model.getStudentName();
		
		rollNo=model.getRollNo();
		
		gmail=model.getGmail();
		
		contact=model.getContact();
		
		gender=model.getGender();
		
		department=model.getDepartment();
		
		return "";
		
	}

	public String updateRecord()
	{
		StudentModel student=new StudentModel();
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		student.setRollNo(rollNo);
		student.setGmail(gmail);
		student.setContact(contact);
		student.setGender(gender);
		student.setDepartment(department);
		
		dao.update(student);
		return "";
	}
}
