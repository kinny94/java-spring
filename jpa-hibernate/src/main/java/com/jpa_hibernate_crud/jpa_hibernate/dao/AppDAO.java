package com.jpa_hibernate_crud.jpa_hibernate.dao;

import com.jpa_hibernate_crud.jpa_hibernate.entity.Course;
import com.jpa_hibernate_crud.jpa_hibernate.entity.Instructor;
import com.jpa_hibernate_crud.jpa_hibernate.entity.InstructorDetail;
import com.jpa_hibernate_crud.jpa_hibernate.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor getInstructor(int id);
    void deleteInstructor(int id);
    List<Instructor> getAllInstructor();
    InstructorDetail getInstructorDetail(int id);
    void deleteInstructorDetail(int id);
    List<InstructorDetail> getAllInstructorDetail();
    List<Course> getAllCourses();
    Course getCourse(int id);
    List<Course> findCourseByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateStudent(Instructor instructor);
    void updateCourse(Course course);
    void deleteCourse(int id);
    void saveCourse(Course course);
    Course findCourseAndReviewsById(int id);
    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
