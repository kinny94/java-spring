package com.jpa_hibernate_crud.jpa_hibernate;

import com.jpa_hibernate_crud.jpa_hibernate.dao.AppDAO;
import com.jpa_hibernate_crud.jpa_hibernate.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
			// findCoursesByInstructor(appDAO);
			// findInstructorByIdJoinFetch(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteInstructorButKeepCourse(appDAO);
			// deleteCourse(appDAO);
			// createCourseAndReviews(appDAO);
			// getCourseAndReviews(appDAO);
			// deleteCourseAndReviews(appDAO);
			// createCourseAndStudents(appDAO);
			// findCourseAndStudentsById(appDAO);
			// findStudentAndCoursesByStudentId(appDAO);
			// addMoreCoursesToStudent(appDAO);
			deleteStudent(appDAO);
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
		appDAO.deleteInstructor(id);
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

	private void findInstructorByIdJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("findInstructorByIdJoinFetch " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println(instructor);
		System.out.println("Associated course " + instructor.getCourses());
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding the instructor " + id);
		Instructor instructor = appDAO.getInstructor(id);
		System.out.println("Updating " + instructor);
		instructor.setFirstName("Benjamin");
		appDAO.updateStudent(instructor);
		System.out.println("Done updating " + instructor);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 11;
		System.out.println("Finding the course " + id);
		Course course = appDAO.getCourse(id);
		System.out.println("Updating " + course);
		course.setTitle("How to get miss entire season twice!");
		appDAO.updateCourse(course);
		System.out.println("Done updating " + course);
	}

	private void addedNewInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Paul@George.com", "George", "Paul");
		InstructorDetail instructorDetail = new InstructorDetail("Basketball", "www.google.com");
		Course course = new Course("How to shoot 3pt 101");
		instructor.add(course);
		instructor.setInstructorDetail(instructorDetail);
		appDAO.save(instructor);
	}

	private void deleteInstructorButKeepCourse(AppDAO appDAO) {
		appDAO.deleteInstructor(4);
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 12;
		appDAO.deleteCourse(id);
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("How to stat pad?");
		course.addReview(new Review("Sad Course....!"));
		course.addReview(new Review("Caitlin Better....!"));
		course.addReview(new Review("Own Rebound machine....!"));
		System.out.println("Saving " + course);
		appDAO.saveCourse(course);
		System.out.println("Done saving " + course);
	}

	private void getCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("findCourseAndReviews " + id);
		Course course = appDAO.findCourseAndReviewsById(id);
		System.out.println("Course " + course);
		System.out.println(course.getReviews());
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting " + id);
		appDAO.deleteCourse(id);
		System.out.println("Done");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("How to stat pad?");
		Student student = new Student("Paul", "George", "Paul@George.com");
		Student student1 = new Student("Russel", "Westbrook", "Russel@Westbrook.com");
		course.addStudent(student);
		course.addStudent(student1);
		System.out.println("Saving " + course);
		System.out.println("Saving associated students " + course.getStudents());
		appDAO.saveCourse(course);
		System.out.println("Done saving " + course);
	}

	private void findCourseAndStudentsById(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(id);
		System.out.println("Course " + course);
		System.out.println("Students " + course.getStudents());
	}

	private void findStudentAndCoursesByStudentId(AppDAO appDAO) {
		int id = 1;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		System.out.println("Student " + student);
		System.out.println("Courses " + student.getCourses());
	}

	private void addMoreCoursesToStudent(AppDAO appDAO) {
		int id = 1;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		Course course = new Course("How to miss layups");
		Course course2 = new Course("How to travel");
		student.addCourse(course);
		student.addCourse(course2);
		System.out.println("Updating " + student);
		appDAO.updateStudent(student);
		System.out.println("Done updating " + student);
		System.out.println("Associated courses " + student.getCourses());
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting " + id);
		appDAO.deleteStudent(id);
		System.out.println("Done");
	}
}
