package com.jspider.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspider.project.entity.Student;

@Component(value = "dao")
public class StudentDao {
	
	@Autowired
	private EntityManager entityManager;

	public void saveStudent(Student student) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("Student Saved");
	}
	
	public Student getStudent(int id) {
		String query="select s from Student s where s.id=?1";
		Query createQuery = entityManager.createQuery(query);
		createQuery.setParameter(1, id);
		return (Student) createQuery.getSingleResult();	
	}
	
//	public Student getStudent(int id) {
//		Student find = entityManager.find(Student.class,1);
//		return find;
//	}
	

	public void updateStudent(int id, Student newStudent) {
		try {
			Student s = getStudent(id);
			EntityTransaction et=entityManager.getTransaction();
			et.begin();
			newStudent.setId(id);
			entityManager.merge(newStudent);
			et.commit();
		} catch (Exception e) {
			System.out.println("Id not Foud");
		}	
	}
	public void deleteStudent(int id) {
		EntityTransaction trx=entityManager.getTransaction();
		Student student=getStudent(id);
		trx.begin();
		entityManager.remove(student);
		trx.commit();
	}
	
	public List<Student> getAllStudent(){
		String query="select s from Student s";
		Query q = entityManager.createQuery(query);
		List<Student> list = q.getResultList();
		return list;
	}
}