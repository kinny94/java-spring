package com.spring.hibernatecrud.dao;
import com.spring.hibernatecrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private final EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    // Transaction is not required for read only
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query and return result
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by firstName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName=:data", Student.class);
        query.setParameter("data", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateAllLastName(String lastName) {
        Query query = entityManager.createQuery(
                "UPDATE Student s SET s.lastName = :newLastName WHERE s.lastName = :customName"
        );
        query.setParameter("newLastName", "Davis");
        query.setParameter("customName", lastName);
        int updates = query.executeUpdate();
        System.out.println("Rows updated: " + updates);
    }

}
