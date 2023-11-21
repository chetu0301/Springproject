package com.lovetocode.cruddemo.dao;
import com.lovetocode.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
    public class StudentDAOImpl implements StudentDAO {

        // define field for entity manager
        private EntityManager entityManager;

        @Autowired
        public StudentDAOImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
        }


        // implement save method
        @Override
        @Transactional
        public void save(Student theStudent) {
            entityManager.persist(theStudent);
        }

        @Override
        public Student findById(Integer id) {
            return entityManager.find(Student.class,id);
        }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by firstName",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theLastNamesRes = entityManager.createQuery("From Student where lastName=:last",Student.class);
        theLastNamesRes.setParameter("last",theLastName);

        return theLastNamesRes.getResultList();
    }

    @Override
    @jakarta.transaction.Transactional
    public void update(Student student) {
            entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int  numRowsDeleted = entityManager.createQuery("delete from Student ").executeUpdate();



        return numRowsDeleted;
    }


}
