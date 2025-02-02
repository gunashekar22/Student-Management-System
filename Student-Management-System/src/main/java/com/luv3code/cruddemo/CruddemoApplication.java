//package com.luv3code.cruddemo;
//
//import com.luv3code.cruddemo.dao.StudentDAO;
//import com.luv3code.cruddemo.entity.Student;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import java.util.Scanner;
//import java.util.List;
//
//@SpringBootApplication
//public class CruddemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CruddemoApplication.class, args);
//	}
//	@Bean
//
//	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//		return runner -> {
//			Scanner scanner = new Scanner(System.in);
//			boolean exit = false;
//
//			while (!exit) {
//				// Display menu options
//				System.out.println("\nPlease select an option:");
//				System.out.println("1. Create Multiple Students");
//				System.out.println("2. Find a Student by ID");
//				System.out.println("3. List All Students");
//				System.out.println("4. Find Students by Last Name");
//				System.out.println("5. Update a Student");
//				System.out.println("6. Delete a Student");
//				System.out.println("7. Delete All Students");
//				System.out.println("8. Exit");
//
//				// Read user input
//				int choice = scanner.nextInt();
//				scanner.nextLine(); // Consume the newline character
//
//				// Perform action based on user choice
//				switch (choice) {
//					case 1:
//						createMultipleStudent(studentDAO);
//						break;
//					case 2:
//						System.out.println("Enter the student ID to find:");
//						int studentId = scanner.nextInt();
//						scanner.nextLine(); // Consume the newline character
//						findStudent(studentDAO, studentId);
//						break;
//					case 3:
//						StudentsList(studentDAO);
//						break;
//					case 4:
//						System.out.println("Enter the last name to search:");
//						String lastName = scanner.nextLine();
//						findByLastName(studentDAO, lastName);
//						break;
//					case 5:
//						System.out.println("Enter the student ID to update:");
//						int updateId = scanner.nextInt();
//						scanner.nextLine(); // Consume the newline character
//						updateStudent(studentDAO, updateId);
//						break;
//					case 6:
//						System.out.println("Enter the student ID to delete:");
//						int deleteId = scanner.nextInt();
//						scanner.nextLine(); // Consume the newline character
//						deleteStudent(studentDAO, deleteId);
//						break;
//					case 7:
//						deleteStudents(studentDAO);
//						break;
//					case 8:
//						exit = true;
//						System.out.println("Exiting...");
//						break;
//					default:
//						System.out.println("Invalid option. Please try again.");
//						break;
//				}
//			}
//
//			scanner.close();
//		};
//	}
//
//	private void deleteStudents(StudentDAO studentDAO) {
//		studentDAO.deleteAll();
//		System.out.println("delted all student");
//	}
//
//	private void deleteStudent(StudentDAO studentDAO, int deleteId) {
//		int id=2;
//		Student theStudent= studentDAO.findById(id);
//		studentDAO.delete(theStudent);
//		System.out.println("delted the student");
//
//
//
//	}
//
//	private void updateStudent(StudentDAO studentDAO, int updateId) {
//		Student student = studentDAO.findById(updateId);
//		if (student != null) {
//			System.out.println("Enter the new first name:");
//			Scanner scanner = new Scanner(System.in);
//			String newFirstName = scanner.nextLine();
//			student.setFirstName(newFirstName);
//			studentDAO.update(student);
//			System.out.println("Updated student with ID: " + updateId);
//		} else {
//			System.out.println("Student with ID " + updateId + " not found.");
//		}
//	}
//	private void findByLastName(StudentDAO studentDAO, String lastName) {
//		List<Student> theStudents=studentDAO.findByLastName(lastName);
//		for(Student temp:theStudents){
//			System.out.println(temp.toString());
//		}
//
//
//	}
//
//	private void StudentsList(StudentDAO studentDAO) {
//		List<Student> theStudents=studentDAO.findAll();
//		for(Student temp:theStudents){
//			System.out.println(temp.toString());
//		}
//	}
//
//
//	private void findStudent(StudentDAO studentDAO, int id) {
//		Student student = studentDAO.find(id);
//		if (student != null) {
//			System.out.println(student.toString());
//		} else {
//			System.out.println("Student with ID " + id + " not found.");
//		}
//	}
//
//
//	private void createStudent(StudentDAO studentDAO) {
//
//		System.out.println("Creating new student");
//		Student tempStudent=new Student("guna","shekar","guna@gmail.com");
//
//		System.out.println("Saving the student");
//		studentDAO.save(tempStudent);
//
//		System.out.println("Saved student. Generated id:"+tempStudent.getId());
//
//
//
//	}
//	private void createMultipleStudent(StudentDAO studentDAO) {
//
//		System.out.println("Creating 3 student");
//		Student tempStudent1=new Student("saahas","undabtla","sahas@gmail.com");
//		Student tempStudent2=new Student("jk","shekar","jk@gmail.com");
//		Student tempStudent3 =new Student("jhon","shekar","jhon@gmail.com");
//		System.out.println("Saving the student");
//		studentDAO.save(tempStudent1);
//		studentDAO.save(tempStudent2);
//		studentDAO.save(tempStudent3);
//
//	}
//
//}
package com.luv3code.cruddemo;

import com.luv3code.cruddemo.dao.StudentDAO;
import com.luv3code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			try (Scanner scanner = new Scanner(System.in)) {
				boolean exit = false;

				while (!exit) {
					// Display menu options
					System.out.println("\nPlease select an option:");
					System.out.println("1. Create Multiple Students");
					System.out.println("2. Find a Student by ID");
					System.out.println("3. List All Students");
					System.out.println("4. Find Students by Last Name");
					System.out.println("5. Update a Student");
					System.out.println("6. Delete a Student");
					System.out.println("7. Delete All Students");
					System.out.println("8. Exit");

					// Read user input
					int choice = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character

					// Perform action based on user choice
					switch (choice) {
						case 1:
							createMultipleStudent(studentDAO);
							break;
						case 2:
							System.out.println("Enter the student ID to find:");
							int studentId = scanner.nextInt();
							scanner.nextLine(); // Consume the newline character
							findStudent(studentDAO, studentId);
							break;
						case 3:
							listStudents(studentDAO);
							break;
						case 4:
							System.out.println("Enter the last name to search:");
							String lastName = scanner.nextLine();
							findByLastName(studentDAO, lastName);
							break;
						case 5:
							System.out.println("Enter the student ID to update:");
							int updateId = scanner.nextInt();
							scanner.nextLine(); // Consume the newline character
							updateStudent(studentDAO, updateId);
							break;
						case 6:
							System.out.println("Enter the student ID to delete:");
							int deleteId = scanner.nextInt();
							scanner.nextLine(); // Consume the newline character
							deleteStudent(studentDAO, deleteId);
							break;
						case 7:
							deleteAllStudents(studentDAO);
							break;
						case 8:
							exit = true;
							System.out.println("Exiting...");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
							break;
					}
				}
			}
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numStudentsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numStudentsDeleted + " students.");
	}

	private void deleteStudent(StudentDAO studentDAO, int deleteId) {
		Student student = studentDAO.findById(deleteId);
		if (student != null) {
			studentDAO.delete(student);
			System.out.println("Deleted student with ID: " + deleteId);
		} else {
			System.out.println("Student with ID " + deleteId + " not found.");
		}
	}

	private void updateStudent(StudentDAO studentDAO, int updateId) {
		Student student = studentDAO.findById(updateId);
		if (student != null) {
			Scanner scanner = new Scanner(System.in);


			System.out.println("Enter the new first name:");
			String newFirstName = scanner.nextLine();
			student.setFirstName(newFirstName);


			System.out.println("Enter the new last name:");
			String newLastName = scanner.nextLine();
			student.setLastName(newLastName);


			System.out.println("Enter the new email:");
			String newEmail = scanner.nextLine();
			student.setEmail(newEmail);


			studentDAO.update(student);

			System.out.println("Updated student with ID: " + updateId);
		} else {
			System.out.println("Student not found with ID: " + updateId);
		}

	}

	private void findByLastName(StudentDAO studentDAO, String lastName) {
		List<Student> students = studentDAO.findByLastName(lastName);
		if (students.isEmpty()) {
			System.out.println("No students found with last name: " + lastName);
		} else {
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}

	private void listStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		if (students.isEmpty()) {
			System.out.println("No students found.");
		} else {
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}

	private void findStudent(StudentDAO studentDAO, int id) {
		Student student = studentDAO.findById(id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 students...");
		Student tempStudent1 = new Student("Saahas", "Undabtla", "sahas@gmail.com");
		Student tempStudent2 = new Student("JK", "Shekar", "jk@gmail.com");
		Student tempStudent3 = new Student("John", "Shekar", "john@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Students saved successfully.");
	}
}