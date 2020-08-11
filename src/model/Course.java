package model;

import java.io.Serializable;

public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private double credit;
	private String courseName;
	private double grade;
	
	public Course(double credit, String courseName, double grade) {
		if (credit > 0 ) {
			this.credit = credit;
		} else {
			this.credit = 0;
		}
		this.courseName = courseName;
		if (grade < 0 || grade > 100 ) {
			this.grade = 0;
		} else {
			this.grade = grade;
		}
	}
	
	public double getCredit() {
		return credit;
	}

	public String getCourseName() {
		return courseName;
	}

	public double getGrade() {
		return grade;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Course other = (Course) obj;
		if (this.courseName.equals(other.getCourseName())) {
			return true;
		}
		return false;
	}

}