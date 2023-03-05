package com.springcore.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springcore.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

	//@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertStudent(Student student) {
		String query ="insert into student(id,name,city) values(?,?,?)";
		int inserted = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return inserted;
	}
	

	public int updateStudent(Student student) {
		String query = "update student set name= ?,city= ? where id= ?";
		int updated = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return updated;
	}


	public int deleteStudent(int studentId) {
		String query = "delete from student where id=?";
		int deleted = this.jdbcTemplate.update(query,studentId);
		return deleted;
	}
	


	public Student getStudentById(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMappperImpl();
		Student getStudentById = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		
		//=========using Anonymous class=============
		
//		Student getStudentById = this.jdbcTemplate.queryForObject(query,  new RowMapper() {
//			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				student.setId(rs.getInt(1));
//				student.setName(rs.getString(2));
//				student.setCity(rs.getString(3));
//				return student;
//			}
//		},studentId);
		return getStudentById;
	}
	

	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> getAllStudents = this.jdbcTemplate.query(query,new RowMappperImpl());
		return getAllStudents;
	}

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
