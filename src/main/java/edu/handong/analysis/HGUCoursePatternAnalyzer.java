package edu.handong.analysis;

import java.util.ArrayList;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer 
{
	int i=0;
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						}; 

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	//private ArrayList<Student> students;
	//private ArrayList<Course> courses;
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) 
	{
		int studentck=0 , courseck=0;
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		
		for(Student student: students) 
		{
			if (studentExist(students,student) == true)
			{
				if (studentck < numOfStudents)
				{
					System.out.println(student.getName());
					studentck++;
				}
			}
			
			if (studentExist(students,student) == false)
				break;
		}
		
		courses = initiateCourseArrayFromLines(lines);
		
		System.out.println("Number of All Courses: " + numOfCourses);
		
		for(Course course: courses) 
		{
			if (courseExist(courses,course) == true)
			{
				if (courseck < numOfCourses)
				{
					System.out.println(course.getCourseName());
					courseck++;	
				}
			}
			
			if (courseExist(courses,course) == false)
				break;
		}
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) 
	{
		
		int ct=0, j=0;
		Student[] st = new Student[lines.length];
		String[] arr = new String[lines.length];
		
		
		
		for (String temp : lines)
		{
			String imsi = temp.split(",")[1];
			imsi= imsi.trim();

			if (i==0)
				arr[ct]=imsi;
			
			if (i!=0)
			{
				if (imsi.equals(arr[ct]))
				{
					i++;
					continue;
				}
				
			if (!(imsi.contentEquals(arr[ct])))
				 arr[++ct]=imsi;
			}
			i++;
		}		
		
		for (String retemp : arr)
		{
			st[j++] = new Student(retemp);		
		}
		return st;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) 
	{
		if (students == null && student == null)
			return false;
		else
			return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines)
	{
		int cct=0, w=0, p=0, chec=0;
		Course[] cs = new Course[lines.length];
		String[] copy = new String[lines.length];
		
		for (String temp2 : lines)
		{
			String imsi = temp2.split(",")[2];
			imsi= imsi.trim();

			for (p=0 ; p<12; p++)
			{
				if (imsi.equals(copy[p]))
					chec++;
			}

			if (chec==0)	
			 copy[cct++]=imsi;
			
			chec =0;			
		}
		
		for (String reimsi : copy)
		{
			cs[w++] = new Course(reimsi);	
		}
		
		return cs;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course)
	{
		if (courses == null && course == null)
			return false;
		else
			return true;
	}

}
