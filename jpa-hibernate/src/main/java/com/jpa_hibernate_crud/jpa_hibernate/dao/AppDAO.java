package com.jpa_hibernate_crud.jpa_hibernate.dao;

import com.jpa_hibernate_crud.jpa_hibernate.entity.Course;
import com.jpa_hibernate_crud.jpa_hibernate.entity.Instructor;
import com.jpa_hibernate_crud.jpa_hibernate.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor getInstructor(int id);
    void delete(int id);
    List<Instructor> getAllInstructor();
    InstructorDetail getInstructorDetail(int id);
    void deleteInstructorDetail(int id);
    List<InstructorDetail> getAllInstructorDetail();
    List<Course> getAllCourses();
    Course getCourse(int id);
    List<Course> findCourseByInstructorId(int id);
}