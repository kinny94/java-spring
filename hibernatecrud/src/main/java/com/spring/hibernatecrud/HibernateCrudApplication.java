package com.spring.hibernatecrud;

import com.spring.hibernatecrud.dao.StudentDAO;
import com.spring.hibernatecrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
			Student studentTest = getStudentWithId(studentDAO, 2);
			System.out.println("Found the student: " + studentTest);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating 3 new students object...");
		Student student1 = new Student("Anthony", "Edwards", "anthony@edwards.com");
		Student student2 = new Student("Anthony", "Davis", "anthony@davis.com");
		Student student3 = new Student("Kevin", "Durant", "Kevin@Durant.com");

		// save the students
		System.out.println("Saving multiple objects...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Arjun", "Dass", "test@test.com");

		// save the student object
		System.out.println("Saving the temp student...");
		studentDAO.save(tempStudent);

		// display the id of the saved object
		System.out.println("Saved student. Id: " + tempStudent.getId());
	}

	private Student getStudentWithId(StudentDAO studentDAO, int id) {
		System.out.println("Getting student with id " + id);
		return studentDAO.findById(id);
	}
}
