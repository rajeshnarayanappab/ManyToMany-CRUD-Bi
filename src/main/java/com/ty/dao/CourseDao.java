package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class CourseDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void save(Course course) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(course);
		entityTransaction.commit();
	}

	public Course getCourse(int id) {
		entityManager = getEntityManager();
		return entityManager.find(Course.class, id);
	}

	public void addStudentsToCourse(int id, List<Student> students) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Course course = entityManager.find(Course.class, id);
		entityTransaction.begin();
		List<Student> list = course.getStudents();
		entityManager.merge(course);
		entityTransaction.commit();
	}

	public void deletOrder(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		Course course = entityManager.find(Course.class, id);
		if (course != null) {
			entityTransaction.begin();
			entityManager.remove(course);
			entityTransaction.commit();
		}

	}
}
