package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	//save student
	@Transactional
	public int insert (Student student) {
		//insert
		Integer i =(Integer) this.hibernateTemplate.save(student);
		return i;
	}
	// get the single data(object)	
	@Transactional
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	// get all student
	@Transactional
	public List<Student> getAllStudent() {
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}
	
	//deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		this.hibernateTemplate.get(Student.class,studentId);
	}
	//update data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
