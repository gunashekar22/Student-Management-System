package com.luv3code.cruddemo.dao;

import com.luv3code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimp implements StudentDAO{

//    Entity manager is used to interact with database
    private EntityManager entityManager;
//    The entity manager is initialised by using autoride
    @Autowired
    public StudentDAOimp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
// Persist is used to save the student in the database ----  save the student

    }

    @Override
    public Student find(int id) {
       return entityManager.find(Student.class,id);

    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> thequery=entityManager.createQuery("Select e from Student e order by firstName asc",Student.class);

        return  thequery.getResultList();

//        return null;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theStudent=entityManager.createQuery("from Student where lastName=:theData",Student.class);
        theStudent.setParameter("theData",lastName);

        return theStudent.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    public Student findById(int id) {
        Student theStudnet=entityManager.find(Student.class,id);
        return theStudnet;
    }

    @Override
    @Transactional
    public void delete(Student theStudent) {
        // Remove the student from the database
        theStudent = entityManager.merge(theStudent);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        entityManager.createQuery("delete from Student").executeUpdate();
        return 0;
    }


}
