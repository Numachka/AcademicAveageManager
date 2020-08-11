package view;

import java.util.Optional;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NoStudentAlertWindow extends Application {

	private final int CREATE = 0;
	private final int EXIT = 1;
	Stage studentCreationStage;
	TextField studentCreationName;
	Button studentCreationSumbit;
	
	public NoStudentAlertWindow() {
		try {
			start(new Stage());
		} catch (Exception e) {
			
		}
	}
	
	public Stage getStudentCreationStage() {
		return studentCreationStage;
	}

	public TextField getStudentCreationName() {
		return studentCreationName;
	}



	public void setStudentCreationName(TextField studentCreationName) {
		this.studentCreationName = studentCreationName;
	}



	public Button getStudentCreationSumbit() {
		return studentCreationSumbit;
	}



	public void setStudentCreationSumbit(Button studentCreationSumbit) {
		this.studentCreationSumbit = studentCreationSumbit;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Student not found window
		 Alert studentNotFound = new Alert(AlertType.INFORMATION, "Student not detected. Create new or exit?",
				new ButtonType("Create"), new ButtonType("Exit"));
		ObservableList<ButtonType> studentNotFoundButtons = studentNotFound.getButtonTypes();
		Optional<ButtonType> result = studentNotFound.showAndWait();
		if (result.isPresent() && result.get() == studentNotFoundButtons.get(CREATE)) {
			// Student creation window
			// Student creation window - Main Pane
			studentCreationStage = new Stage();
			studentCreationStage.setTitle("Creating new student");
			GridPane studentCreationPane = new GridPane();
			studentCreationPane.setPadding(new Insets(10));
			// Student creation window - Components
			Label studentCreationMessage = new Label("Enter students name: ");
			GridPane.setConstraints(studentCreationMessage, 0, 0);
			studentCreationName = new TextField();
			GridPane.setConstraints(studentCreationName, 0, 1);
			 studentCreationSumbit = new Button("Submit");
			GridPane.setMargin(studentCreationSumbit, new Insets(5));
			GridPane.setConstraints(studentCreationSumbit, 1, 1);
			// Student creation window - Stage setting
			studentCreationPane.getChildren().addAll(studentCreationMessage, studentCreationName,
					studentCreationSumbit);
			Scene studentScene = new Scene(studentCreationPane);
			studentCreationStage.setScene(studentScene);
			studentCreationStage.show();
			
			//TODO logic for create button.
		} else if (result.isPresent() && result.get() == studentNotFoundButtons.get(EXIT)) {
			System.exit(0);
		}

	}
}
