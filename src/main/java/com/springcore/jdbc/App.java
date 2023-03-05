package com.springcore.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springcore.Dao.StudentDao;
import com.springcore.entity.Student;


public class App {
	
	public static void main(String[] args) {
		System.out.println("Database Connection Successful....");
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/jdbc/JdbcConfig.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		
		//way -1
//		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
//		
//		//insert 
//		String query = "insert into student(id,name,city) values(?,?,?)";
//		
//		//fire query
//		int result = template.update(query,2,"Ameer","Bang");
//		System.out.println("number of record inserted:"+ result);
//		
		//insert way 2
		StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		 
//		Student student = new Student();
//		student.setId(11);
//		student.setName("Sameer");
//		student.setCity("Odisha");
//		
//		int insertStudent = studentDao.insertStudent(student);
//		System.out.println("Student Added .. "+insertStudent);
		
		//=================update student==================
		
//		Student student = new Student();
//		student.setId(1);
//		student.setName("Sameer Kumar");
//		student.setCity("Chichinda");
//		int updateStudent = studentDao.updateStudent(student);
//		System.out.println("Student updated..."+updateStudent);
		
		//=================delete student====================
		
//		int deleteStudent = studentDao.deleteStudent(11);
//		System.out.println("Delete successfully..."+deleteStudent);
		
		//=======================getStudent By Id===================
		
//		Student studentById = studentDao.getStudentById(2);
//		System.out.println(studentById);
		
		//=====================get All students===============
		
		List<Student> allStudent = studentDao.getAllStudent();
		for (Student student : allStudent) {
			System.out.println(student);
		}
	}

}
