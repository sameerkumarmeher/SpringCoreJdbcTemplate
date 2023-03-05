package com.springcore.Dao;

import java.util.List;

import com.springcore.entity.Student;

public interface StudentDao {

	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int studentId);
	public Student getStudentById(int studentId);
	public List<Student> getAllStudent();
}
