package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Course;
import model.Student;
import view.AddCourseWindow;
import view.MainWindow;
import view.NoStudentAlertWindow;
import view.RemoveCourseWindow;

public class DataController {

	private final String FILENAME = "student.txt";
	private Student student;
	private MainWindow mainWindow;
	private AddCourseWindow addCourseWindow;
	private RemoveCourseWindow removeCourseWindow;
	private NoStudentAlertWindow noStudentAlertWindow;

	public DataController() {
		this.student = new Student("NoName");
		this.mainWindow = new MainWindow();
		this.addCourseWindow = null;
		this.removeCourseWindow = null;
		this.noStudentAlertWindow = null;
		checkForStudent();
		listeners();
	}

	private void checkForStudent() {
		try {
			student = loadStudentFromFile();
			if (student.getStudentName().equals("NoName")) {
				noStudentAlertWindow = new NoStudentAlertWindow();
				noStudentAlertWindow.getStudentCreationSumbit().setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						student = new Student(noStudentAlertWindow.getStudentCreationName().getText());
						updateTableView();
						saveStudentToFile(student);
					}
				});
			} else {
				updateTableView();
				return;
			}
		} catch (Exception e2) {
			noStudentAlertWindow = new NoStudentAlertWindow();
			noStudentAlertWindow.getStudentCreationSumbit().setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					student = new Student(noStudentAlertWindow.getStudentCreationName().getText());
					updateTableView();
					saveStudentToFile(student);
					noStudentAlertWindow.getStudentCreationStage().close();
				}

			});
		}
	}

	public void listeners() {

		mainWindow.getAdd().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addCourseWindow = new AddCourseWindow();
				addCourseWindow.getCourseCreationSumbit().setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						Double credit = new Double(addCourseWindow.getCourseCreationCredit().getText());
						String courseName = addCourseWindow.getCourseCreationName().getText();
						Double grade = new Double(addCourseWindow.getCourseCreationGrade().getText());
						student.addCourse(new Course(credit, courseName, grade));
						updateTableView();
						saveStudentToFile(student);
						addCourseWindow.getCourseCreationStage().close();
					}
				});
			}
		});

		mainWindow.getRemove().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				removeCourseWindow = new RemoveCourseWindow();
				removeCourseWindow.getCourseDeletionSubmit().setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						String courseName = removeCourseWindow.getCourseDeletionField().getText();
						Course courseToRemove = student.removeCourse(new Course(0, courseName, 0));
						if (courseToRemove != null) {
							mainWindow.getObservableCourseTable().remove(courseToRemove);
							updateTableView();
							saveStudentToFile(student);
							removeCourseWindow.getCourseDeletionStage().close();
						}
						removeCourseWindow.getCourseDeletionStage().close();
					}
				});
			}
		});

		mainWindow.getExit().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainWindow.getPrimaryStage().close();
			}
		});
	}

	public void updateTableView() {
		ObservableList<Course> observableTable = FXCollections.observableArrayList(student.getCourses());
		mainWindow.getCourseTable().setItems(observableTable);
		mainWindow.getStudentName().setText("Welcome " + student.getStudentName());
		mainWindow.getAcademicCredits().setText("Academic Credits: " + student.getAcademicCredit());
		mainWindow.getAcademicAverage().setText("Academic Average: " + student.getAcademicAverage());
	}

	public void saveStudentToFile(Student student) {
		try (ObjectOutputStream o = new ObjectOutputStream(
				(new BufferedOutputStream(new FileOutputStream(FILENAME))))) {
			o.writeObject(student);
		} catch (Exception e) {
			
		}
	}

	public Student loadStudentFromFile() {
		Student student = null;
		BufferedInputStream bi;
		try (ObjectInputStream o = new ObjectInputStream(
				(bi = new BufferedInputStream(new FileInputStream(FILENAME))))) {
			while (bi.available() > 0) {
				student = (Student) o.readObject();
			}
			return student;
		} catch (Exception exc) {
			student = null;
			return student;
		}
	}

}
