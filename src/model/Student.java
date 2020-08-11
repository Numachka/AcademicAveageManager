package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.ArrayList;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private String studentName;
	private ArrayList<Course> courses;
	private double academicCredit;
	private double academicAverage;

	public Student(String studentName) {
		this.studentName = studentName;
		this.courses = new ArrayList<Course>();
		this.academicCredit = 0;
		this.academicAverage = 0;
	}

	public String getStudentName() {
		return studentName;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public double getAcademicCredit() {
		return academicCredit;
	}

	public double getAcademicAverage() {
		return academicAverage;
	}

	public void addCourse(Course course) {
		courses.add(course);
		academicCredit += course.getCredit();
		// addItemToAcademicAverage(course);
		recalculateAcademicAverage();
	}

	public Course removeCourse(Course removedCourse) {
		int index = Collections.binarySearch(courses, removedCourse, new SortByName());
		if (index >= 0) {
			Course returnedCourse = courses.get(index);
			// removeItemFromAcademicAverage(returnedCourse);
			courses.remove(index);
			recalculateAcademicAverage();
			return returnedCourse;
		} else {
			return null;
		}
	}

//	private void removeItemFromAcademicAverage(Course course) {
//		double grade = course.getGrade();
//		double credit = course.getCredit();
//		double totalGrade = getAcademicAverage();
//		double totalCredit = getAcademicCredit();
//		this.academicAverage = (totalGrade * (1 + credit / (totalCredit - credit)) - ((credit * grade) / totalCredit - credit));
//	}
//
//	public void addItemToAcademicAverage(Course course) {
//		double grade = course.getGrade();
//		double credit = course.getCredit();
//		double totalGrade = getAcademicAverage();
//		double totalCredit = getAcademicCredit();
//		if (this.courses.size() == 1) {
//			this.academicAverage = grade;
//		} else {
//			this.academicAverage = (totalGrade + ((credit / (totalCredit - credit) * (totalGrade - grade))));
//		}
//	}

	public void recalculateAcademicAverage() {
		double nominator = 0;
		double denominator = 0;
		for (Course course : courses) {
			nominator += (course.getCredit() * course.getGrade());
			denominator += course.getCredit();
		}
		academicCredit = denominator;
		if (denominator > 0) {
			academicAverage = nominator / denominator;
		} else {
			academicAverage = 0;
		}
	}
}
