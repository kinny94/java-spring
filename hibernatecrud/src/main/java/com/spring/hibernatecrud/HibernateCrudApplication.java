package com.spring.hibernatecrud;

import com.spring.hibernatecrud.dao.StudentDAO;
import com.spring.hibernatecrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			setAutoIncrement(studentDAO);
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			Student studentTest = getStudentWithId(studentDAO, 2);
			System.out.println("Found the student: " + studentTest);
			List<Student> students = getAllStudents(studentDAO);
			System.out.println(students);
			getStudentsWithLastName(studentDAO, "Edwards");
			Student updatedStudent = updateStudent(studentDAO, 3);
			System.out.println(updatedStudent);
			updateLastNameForAllStudentsWithCurryLastName(studentDAO, "Curry");
			createStudent(studentDAO);
			Student deletedStudent = deleteStudent(studentDAO, 5);
			System.out.println(deletedStudent);
			System.out.println(deleteAllStudents(studentDAO) + " students deleted!!");
		};
	}

	private void setAutoIncrement(StudentDAO studentDAO) {
		System.out.println("Setting auto-increment to 1");
		studentDAO.setAutoIncrement();
	}

	private int deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		return studentDAO.deleteAllStudents();
	}

	private Student deleteStudent(StudentDAO studentDAO, int id) {
		System.out.println("Deleting student with id: " + id);
		return studentDAO.deleteById(id);
	}

	private void updateLastNameForAllStudentsWithCurryLastName(StudentDAO studentDAO, String updatedLastName) {
		studentDAO.updateAllLastName(updatedLastName);
	}

	private void getStudentsWithLastName(StudentDAO studentDAO, String lastName) {
		System.out.println("Getting students with last name: " + lastName);
		List<Student> students = studentDAO.findByLastName(lastName);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private Student updateStudent(StudentDAO studentDAO, int id) {
		System.out.println("Getting student with id: " + id);
		Student student = getStudentWithId(studentDAO, id);
		System.out.println("Updating student...");
		student.setLastName("Curry");
		System.out.println("Updating student...");
		return studentDAO.update(student);
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

	private List<Student> getAllStudents(StudentDAO studentDAO) {
		System.out.println("Getting all students...");
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student.getFirstName() + " " + student.getLastName());
		}
		return studentDAO.findAll();
	}
}
