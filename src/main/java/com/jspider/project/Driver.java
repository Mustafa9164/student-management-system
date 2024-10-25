package com.jspider.project;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspider.project.configuration.StudentConfig;
import com.jspider.project.dao.StudentDao;
import com.jspider.project.entity.Student;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(StudentConfig.class);
		StudentDao studentDao = ac.getBean("dao",StudentDao.class);
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1:save\n2:fetchById\n3:update\n4:delete\n5:AllEmployee");
			System.out.println("Eneter choice");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				System.err.println("Save Student in DB");
				Student s=new Student();
				System.out.println("Eneter Student name");
				String name = sc.next();
				s.setName(name);
				System.out.println("Eneter Student School");
				String school = sc.next();
				s.setSchool(school);
				System.out.println("Eneter mobile number");
				long phone = sc.nextLong();
				s.setPhone(phone);
				System.out.println("Eneter Address");
				String address = sc.next();
				s.setAddress(address);
				studentDao.saveStudent(s);
				break;
			case 2:
				System.err.println("Enter id to fetch all record");
				int stid = sc.nextInt();
				Student student = studentDao.getStudent(stid);
				System.out.println(student);
				break;
			case 3:
				Student st=new Student();
				System.out.println("Enter id");
				int sid = sc.nextInt();
				st.setId(sid);
				System.out.println("Eneter Student name");
				String sname = sc.next();
				st.setName(sname);
				System.out.println("Eneter Student School");
				String sschool = sc.next();
				st.setSchool(sschool);
				System.out.println("Eneter mobile number");
				long mphone = sc.nextLong();
				st.setPhone(mphone);
				System.out.println("Eneter Address");
				String addr = sc.next();
				st.setAddress(addr);
				studentDao.updateStudent(sid, st);
				break;
			case 4:
				System.out.println("remove Student by Id");
				int stdid = sc.nextInt();
				studentDao.deleteStudent(stdid);
				break;
			case 5:
				System.out.println("List of Student");
				List<Student> allStudent = studentDao.getAllStudent();
				for (Student student1 : allStudent) {
					System.out.println(student1);
				}
				System.exit(0);
				break;
				
			default:System.out.println("Invalid choice");
				break;
			
			
		}
	
		
//		
		
//		Student student = studentDao.getStudent(1);
//		System.out.println(student);
		
//		studentDao.updateStudent(2, s);
		
//		List<Student> allStudent = studentDao.getAllStudent();
//		System.out.println(allStudent);
		
//		
		}
	}

}
