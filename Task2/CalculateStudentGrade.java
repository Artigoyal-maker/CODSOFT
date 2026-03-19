package Student_Grade_Calculator;
import java.util.Scanner;

public class CalculateStudentGrade {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter the number of subjects: ");
		int subjects = s.nextInt();
		double totalMarks = 0;
		
		for(int i = 1; i<=subjects; i++) {
			System.out.print("Enter marks for subject "+i+"(out of 100): ");
			double marks = s.nextDouble();
			totalMarks += marks;
		}
		double average = totalMarks / subjects;
		String grade;
		
		if(average >= 95)
			grade = "A+";
		else if(average >= 85)
			grade = "A";
		else if(average >= 75)
			grade = "B";
		else if(average >= 65)
			grade = "C";
		else if(average >= 55)
			grade = "D";
		else 
			grade = "F";
		
		System.out.println("Total Marks Obtained: "+totalMarks);
		System.out.println("Average Percentage: "+average+ "%");
		System.out.print("Grade: "+grade);
		
		s.close();
	}
}