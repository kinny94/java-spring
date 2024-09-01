package com.jpa_hibernate_crud.jpa_hibernate.dao;

import com.jpa_hibernate_crud.jpa_hibernate.entity.Course;
import com.jpa_hibernate_crud.jpa_hibernate.entity.Instructor;
import com.jpa_hibernate_crud.jpa_hibernate.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor getInstructor(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return entityManager.createQuery("from Instructor", Instructor.class).getResultList();
    }

    @Override
    public InstructorDetail getInstructorDetail(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<InstructorDetail> getAllInstructorDetail() {
        return entityManager.createQuery("from InstructorDetail", InstructorDetail.class).getResultList();
    }

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course getCourse(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> findCourseByInstructorId(int id) {
        TypedQuery query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data", id);
        List<Course> courses = query.getResultList();
        return courses;
    }
}
