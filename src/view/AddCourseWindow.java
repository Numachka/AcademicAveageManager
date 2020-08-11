package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddCourseWindow {

	private Stage courseCreationStage;
	private TextField courseCreationCredit;
	private TextField courseCreationName;
	private TextField courseCreationGrade;
	private Button courseCreationSumbit;

	public AddCourseWindow() {
		// Add course window
		courseCreationStage = new Stage();
		courseCreationStage.setTitle("Creating new course");
		VBox courseCreationPane = new VBox();
		courseCreationPane.setPadding(new Insets(10));
		// Add course window - Components
		Label courseCreationCreditText = new Label("Enter course credit: ");
		courseCreationCredit = new TextField();
		Label courseCreationNameText = new Label("Enter course name: ");
		courseCreationName = new TextField();
		Label courseCreationGradeText = new Label("Enter course grade: ");
		courseCreationGrade = new TextField();
		courseCreationSumbit = new Button("Submit");
		VBox.setMargin(courseCreationSumbit, new Insets(5, 0, 5, 0));
		// Add course window - Stage setting
		courseCreationPane.getChildren().addAll(courseCreationCreditText, courseCreationCredit, courseCreationNameText,
				courseCreationName, courseCreationGradeText, courseCreationGrade, courseCreationSumbit);
		Scene courseScene = new Scene(courseCreationPane);
		courseCreationStage.setScene(courseScene);
		courseCreationStage.show();
	}

	public Stage getCourseCreationStage() {
		return courseCreationStage;
	}

	public void setCourseCreationStage(Stage courseCreationStage) {
		this.courseCreationStage = courseCreationStage;
	}

	public TextField getCourseCreationCredit() {
		return courseCreationCredit;
	}

	public void setCourseCreationCredit(TextField courseCreationCredit) {
		this.courseCreationCredit = courseCreationCredit;
	}

	public TextField getCourseCreationName() {
		return courseCreationName;
	}

	public void setCourseCreationName(TextField courseCreationName) {
		this.courseCreationName = courseCreationName;
	}

	public TextField getCourseCreationGrade() {
		return courseCreationGrade;
	}

	public void setCourseCreationGrade(TextField courseCreationGrade) {
		this.courseCreationGrade = courseCreationGrade;
	}

	public Button getCourseCreationSumbit() {
		return courseCreationSumbit;
	}

	public void setCourseCreationSumbit(Button courseCreationSumbit) {
		this.courseCreationSumbit = courseCreationSumbit;
	}
}
