package com.lovetocode.cruddemo;

import com.lovetocode.cruddemo.dao.StudentDAO;
import com.lovetocode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//reachStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentLast(studentDAO);
			//queryUpdate(studentDAO);
			//queryDelete(studentDAO);
			//queryDeleteAll(studentDAO);
		};
	}

	private void queryDeleteAll(StudentDAO deleteAllStudents) {
		int numberOfDeltedStudents = deleteAllStudents.deleteAll();
		System.out.println(numberOfDeltedStudents);

	}

	private void queryDelete(StudentDAO deleteStudent) {
		int studentId = 4;
		Student myDeleteStudent = deleteStudent.findById(studentId);
		deleteStudent.delete(studentId);
	}

	private void queryUpdate(StudentDAO studentDAO) {
		int  studentId =4;
		Student myStudent = studentDAO.findById(studentId);
		myStudent.setLastName("Colwick");
		studentDAO.update(myStudent);
		System.out.println(myStudent);
	}

	private void queryForStudentLast(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Applebum");
		for (Student st: theStudents){
			System.out.println(st);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student st: theStudents){
			System.out.println(st);
		}
	}

	private void reachStudent(StudentDAO studentDAO) {
		Student tempStudent5 = new Student("ram","raju","ram@ggmail.com");
		studentDAO.save(tempStudent5);
		//Student myStudent = studentDAO.findById(1);
		//System.out.println(myStudent.getFirstName());

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 4 student objects ...");
		Student tempStudent1 = new Student("Chaitanya", "jana", "chetuchaitanya@gmail.com");
		Student tempStudent2 = new Student("charan", "Public", "charan@gmail.com");
		Student tempStudent3 = new Student("pavan", "Applebum", "pavan@gmail.com");
		Student tempStudent4 = new Student("lokesh", "Applebum", "lokesh@gmail.com");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
