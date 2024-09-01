package com.jpa_hibernate_crud.jpa_hibernate;

import com.jpa_hibernate_crud.jpa_hibernate.dao.AppDAO;
import com.jpa_hibernate_crud.jpa_hibernate.entity.Course;
import com.jpa_hibernate_crud.jpa_hibernate.entity.Instructor;
import com.jpa_hibernate_crud.jpa_hibernate.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// getAllInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// getAllInstructorDetails(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// getAllCourses(appDAO);
			// getCourse(appDAO);
			// findInstructorWithCourse(appDAO);
			findCoursesByInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("James@Harden.com", "Harden", "James");
		InstructorDetail instructorDetail = new InstructorDetail("Basketball", "http://www.youtube.com");
		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving " + instructor);
		appDAO.save(instructor);
		System.out.println("Done saving " + instructor);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding " + id);
		Instructor instructor = appDAO.getInstructor(id);
		System.out.println(instructor.toString());
		System.out.println(instructor.getInstructorDetail());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting " + id);
		appDAO.delete(id);
		System.out.println("Done deleting " + id);
	}

	private void getAllInstructor(AppDAO appDAO) {
		List<Instructor> instructorList = appDAO.getAllInstructor();
		instructorList.forEach(System.out::println);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id =2;
		InstructorDetail instructorDetail = appDAO.getInstructorDetail(id);
		System.out.println("Found " + instructorDetail);
		System.out.println("Associated Instructor " + instructorDetail.getInstructor());
	}

	private void getAllInstructorDetails(AppDAO appDAO) {
		List<InstructorDetail> instructorDetailList = appDAO.getAllInstructorDetail();
		instructorDetailList.forEach(System.out::println);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 6;
		System.out.println("Deleting " + id);
		appDAO.deleteInstructorDetail(id);
		System.out.println("Done deleting " + id);
		getAllInstructor(appDAO);
		getAllInstructorDetails(appDAO);
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Ben@Simmons.com", "Simmons", "Ben");
		InstructorDetail instructorDetail = new InstructorDetail("Injury", "www.google.com");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("How to get Injured 101!");
		Course course2 = new Course("How to miss entire season!");
		instructor.add(course1);
		instructor.add(course2);
		appDAO.save(instructor);
		System.out.println("Done saving " + instructor);
		System.out.println("Courses Saved " + instructor.getCourses());
	}

	private void getCourse(AppDAO appDAO) {
		int id = 1;
		Course course = appDAO.getCourse(1);
		System.out.println("Found " + course);
	}

	private void getAllCourses(AppDAO appDAO) {
		List<Course> courseList = appDAO.getAllCourses();
		courseList.forEach(System.out::println);
	}

	private void findInstructorWithCourse(AppDAO appDAO) {
		int id = 1;
		System.out.println("findInstructorWithCourse " + id);
		Instructor instructor = appDAO.getInstructor(id);
		System.out.println(instructor);
		System.out.println("Associated courses " + instructor.getCourses().toString());
	}

	private void findCoursesByInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Find instructor " + id);
		Instructor instructor = appDAO.getInstructor(id);
		System.out.println(instructor);
		System.out.println("Finding courses....");
		List<Course> courseList = appDAO.findCourseByInstructorId(instructor.getId());
		instructor.setCourses(courseList);
		System.out.println("Associated courses " + instructor.getCourses());
		System.out.println("Done");
	}
}
