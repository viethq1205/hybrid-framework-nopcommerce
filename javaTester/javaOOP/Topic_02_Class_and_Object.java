package javaOOP;

public class Topic_02_Class_and_Object {
	private int studentID;
	private String studentName;
	private Float practicalGrade; // điểm thực hành
	private Float theoryGrade; // điểm lý thuyết

	protected int getStudentID() {
		return studentID;
	}

	protected void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	protected String getStudentName() {
		return studentName;
	}

	protected void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	protected Float getPracticalGrade() {
		return practicalGrade;
	}

	protected void setPracticalGrade(Float practicalGrade) {
		this.practicalGrade = practicalGrade;
	}

	protected Float getTheoryGrade() {
		return theoryGrade;
	}

	protected void setTheoryGrade(Float theoryGrade) {
		this.theoryGrade = theoryGrade;
	}

	protected Float getAverageGrade() {
		return (this.theoryGrade + this.practicalGrade * 2) / 3; // điểm thực hành hệ 2 nên *2
	}

	protected void showStudentInfo() {
		System.out.println("*****************************************************************");
		System.out.println("Student ID: " + getStudentID());
		System.out.println("Student Name: " + getStudentName());
		System.out.println("Student Theory Grade: " + getTheoryGrade());
		System.out.println("Student Practical Grade: " + getPracticalGrade());
		System.out.println("Student Average Grade: " + getAverageGrade());
	}

	public static void main(String[] args) {
		// cách 1
		Topic_02_Class_and_Object secondStudent = new Topic_02_Class_and_Object();
		secondStudent.setStudentID(205207);
		secondStudent.setStudentName("Saka");
		secondStudent.setTheoryGrade(8.5f);
		secondStudent.setPracticalGrade(8.0f);
		secondStudent.showStudentInfo();

		// hoặc dùng cách ngắn gọn hơn đã làm tương tự bên CarOOP
		// public Topic_02_Class_and_Object(int studentID, String studentName, Float practicalGrade, Float theoryGrade) {
		// this.studentID = studentID;
		// this.studentName = studentName;
		// this.practicalGrade = practicalGrade;
		// this.theoryGrade = theoryGrade;
		// }

		// gán như này sẽ gọn hơn so với nhiều dòng bên trên
		// Topic_02_Class_and_Object firstStudent = new Topic_02_Class_and_Object(205206, "Mudryk", 8.0f, 7.8f);
		// firstStudent.showStudentInfo();
	}

}
