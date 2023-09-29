package student_manage;

import java.io.IOException;
import java.util.Scanner;

import com.student.manage.Student;

public class start {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Welcome to student management app!");
		while(true) {
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display student");
			System.out.println("Press 4 to exit app");
			int c = sc.nextInt();
			sc.nextLine();
			if(c==1) {
				//Add student
				System.out.println("Enter User name: ");
				String name = sc.nextLine();
				
				System.out.println("Enter user phone");
				String phone = sc.nextLine();
				
				System.out.println("Enter user city");
				String city = sc.nextLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				System.out.println(st);
				if(answer) {
					System.out.println("Student is added successfully...");
				}
				else {
					System.out.println("Something went wrong try again...");
				}
			}
			else if( c== 2) {
				// delete student
				System.out.println("Enter student ID to delete: ");
				int userID = sc.nextInt();
				boolean f = StudentDao.deleteStudent(userID);	
				if(f) {
					System.out.println("Student is deleted successfully...");
				}
				else {
					System.out.println("Something went wrong try again...");
				}
			}
			else if( c==3) {
				// display student
				StudentDao.showAllStudent();
			}
			else if( c== 4) {
				//exit
				break;
			}
			else {}
			
		}
		System.out.println("Thank You for using student management app!");

	}

}