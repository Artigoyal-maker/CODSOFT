package Student_Management_System;
import java.util.*;

class Student{
	private String name;
	private int rollNo;
	private String grade;
	
	public Student(String name, int rollNo, String grade) {
	    this.name = name;
	    this.rollNo = rollNo;
	    this.grade = grade;
	}
	
	public void setName(String name) {
	    this.name = name;
	}

	public void setGrade(String grade) {
	    this.grade = grade;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public String toString() {
        return "Roll Number: " + rollNo +
               ", Name: " + name +
               ", Grade: " + grade;
    }
}

class StudentManagementSystem {
	 private List<Student> students = new ArrayList<>();
	 
	 public void addStudent(Student s) {
		    if(searchStudent(s.getRollNo()) != null) {
		        System.out.println("Roll number already exists!");
		        return;
		    }
		    students.add(s);
		    System.out.println("Student added successfully!");
		}
	 
	 public void removeStudent(int rollNo) {
	        boolean found = students.removeIf(s -> s.getRollNo() == rollNo);
	        if(found)
	            System.out.println("Student removed.");
	        else
	            System.out.println("Student not found.");
	    }
	 
	 public Student searchStudent(int rollNo) {
	        for(Student s : students) {
	            if(s.getRollNo() == rollNo)
	                return s;
	        }
	        return null;
	    }
	 
	 public List<Student> getAllStudents(){
		 return students;
	 }
	 
	 public void editStudent(int rollNo, String newName, String newGrade) {
		    Student s = searchStudent(rollNo);
		    if(s != null) {
		        // We need setters → add them in Student class
		        s.setName(newName);
		        s.setGrade(newGrade);
		        System.out.println("Student updated successfully!");
		    } else {
		        System.out.println("Student not found.");
		    }
		}
}

public class Student_Management_System {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StudentManagementSystem sms = new StudentManagementSystem();
		
		 while(true) {
	            System.out.println("\n===== Student Management System =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. Remove Student");
	            System.out.println("3. Search Student");
	            System.out.println("4. Display All Students");
	            System.out.println("5. Edit Student");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");
	            int choice = s.nextInt();
	            
	            switch(choice) {
	                case 1:
	                	s.nextLine();
	                    System.out.print("Enter Student Name: ");
	                    String name = s.nextLine();
	                    if(name.isEmpty()) {
	                        System.out.println("Name cannot be empty!");
	                        break;
	                    }
	                    System.out.print("Enter Roll Number: ");
	                    int rollNo = s.nextInt();
	                    if(rollNo <= 0) {
	                        System.out.println("Invalid Roll Number!");
	                        break;
	                    }
	                    System.out.print("Enter Grade: ");
	                    String grade = s.next();
	                    sms.addStudent(new Student(name, rollNo, grade));
	                    break;
	                    
	                case 2:
	                	System.out.print("Enter roll number of student to remove: ");
	                    sms.removeStudent(s.nextInt());
	                    break;
	                case 3:
	                	 System.out.print("Enter roll number of student to search: ");
	                     Student st = sms.searchStudent(s.nextInt());
	                     if(st != null)
	                         System.out.println(st);
	                     else
	                         System.out.println("Student not found.");
	                     break;

	                case 4:
	                    List<Student> allStudents = sms.getAllStudents();
	                    if(allStudents.isEmpty()) {
	                        System.out.println("No students to display.");
	                    } else {
	                        System.out.println("\n----- Student List -----");
	                        for(Student student : allStudents) {
	                            System.out.println(student);
	                        }
	                    }
	                    break;
	                	 
	                 case 5:
	                	    System.out.print("Enter Roll Number to edit: ");
	                	    int r = s.nextInt();
	                	    s.nextLine();

	                	    System.out.print("Enter new name: ");
	                	    String newName = s.nextLine();

	                	    System.out.print("Enter new grade: ");
	                	    String newGrade = s.next();

	                	    sms.editStudent(r, newName, newGrade);
	                	    break;
	                	    
	                 case 6:
	                	 System.out.println("Exiting...");
	                	 s.close();
	                	 System.exit(0);
	                	 break;
	                
	                default:
	                	System.out.println("Invalid choice. Please choose again.");
	                	break;
	            }    
	     }           
	}
}
