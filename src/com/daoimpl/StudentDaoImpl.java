package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.dao.StudentDao;
import com.models.StudentModel;


public class StudentDaoImpl implements StudentDao{
	
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	 
	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	
	
	//Method to add Data in database
	
	
	public void addStudent(StudentModel student)
	{
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		
		session.save(student);
		
		
		t.commit();
		
		session.close();
	}
	
	
	
	
	
	
	public List<StudentModel> getAll()
	{
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		

		String hql = "FROM StudentModel";
		Query query = session.createQuery(hql);
		List<StudentModel> list = query.list();
		
		this.getClass().getClassLoader();
		
		t.commit();
		session.close();
		
		return list;
	}
	
	
	
	
	public void delete(StudentModel student)
	{
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		session.delete(student);
		
		
		t.commit();
		
		session.close();
	}
	
	public StudentModel getById(int id)
    {
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		StudentModel student=session.get(StudentModel.class, id);
		
		t.commit();
		session.close();
		
		return student;
		
		
      
    }
	
	public void update(StudentModel student)
	{	
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		session.saveOrUpdate(student);
		
		t.commit();
		session.close();
	}

}
