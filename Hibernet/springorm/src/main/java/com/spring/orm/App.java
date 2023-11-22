package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( " Programe started................" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
          StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//          Student student = new Student(2345, "sujan shrestha", "salt lake City");
//          int r = studentDao.insert(student);
//          System.out.println("inserted into Student Table:" + r);
          
          BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));        
          boolean go = true;
          while(go) {
        	  System.out.println("press 1 for insert");
              System.out.println("press 2 for display all student");
              System.out.println("press 3  for single student ");
              System.out.println("press 4 for delete student");
              System.out.println("press 5 for update studnet");
              System.out.println("press 6 for exit");
          
          try {
        	  int input = Integer.parseInt(bReader.readLine());
        	  switch (input) {
			case 1: // add student
				// taking input from user
				System.out.println("Enter uder id : ");
				int uId = Integer.parseInt(bReader.readLine());
				
				System.out.println("Enter user name: ");
				String uName = bReader.readLine();
				
				System.out.println("Enter user City: ");
				String uCity = bReader.readLine();
				//creating student object and setting value
				Student s = new Student();
				s.setStudentId(uId);
				s.setStudentName(uName);
				s.setStudentCity(uCity);
				// saving student data into DB by calling insert method from SudentDao
				int r = studentDao.insert(s);
				System.out.println(r  + "student added");
				break;
			case 2 : // display all student
				List<Student> allStudents = studentDao.getAllStudent();
				for(Student st:allStudents) {
					System.out.println(" Id:" + st.getStudentId());
					System.out.println("Name:" + st.getStudentName());
					System.out.println("City:" + st.getStudentCity());
					System.out.println("-----------------------------------------------------------");
				}
			
				break;
			case 3:// fetching single student
				System.out.println("Enter uder id : ");
				int userId = Integer.parseInt(bReader.readLine());
				Student student =  studentDao.getStudent(userId);
				System.out.println(" Id:" + student.getStudentId());
				System.out.println("Name:" + student.getStudentName());
				System.out.println("City:" + student.getStudentCity());
				break;
			case 4: //delete student data from DB
				System.out.println("Enter uder id : ");
				int id = Integer.parseInt(bReader.readLine());
				studentDao.deleteStudent(id);
				System.out.println("student deleted.................");
				break;
			case 5://update student
				// Need to work.......... Pls work on this.
				
				break;
			case 6:
				// Exit
			go = false;				
			break;
        	  }
			   	  		
		} catch (Exception e) {
			System.out.println("invalid input");
			System.out.println(e.getMessage());
		}
          System.out.println(" thank you for using application!");
          System.out.println(" see you soon!!");
         }
    }
}
