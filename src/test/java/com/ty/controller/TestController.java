package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dao.CourseDao;
import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestController {
	public static void main(String[] args) {
	
		Course course = new Course();
		course.setId(1);
		course.setName("java");
		course.setDays(20);
		
		
		Student student = new Student();
		student.setId(1);
		student.setName("sidda");
		
		Student student1 = new Student();
		student1.setId(2);
		student1.setName("tejas");
		
		Student student2 = new Student();
		student2.setId(3);
		student2.setName("madhan");
		
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		list.add(student1);
		list.add(student2);
		
		course.setStudents(list);
		
		CourseDao dao = new CourseDao();
		
dao.save(course);

		
	}

}
