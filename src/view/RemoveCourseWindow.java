package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveCourseWindow {
	
	private Stage courseDeletionStage;
	private TextField courseDeletionField;
	private Button courseDeletionSubmit;
	
	
	
	public Stage getCourseDeletionStage() {
		return courseDeletionStage;
	}



	public void setCourseDeletionStage(Stage courseDeletionStage) {
		this.courseDeletionStage = courseDeletionStage;
	}



	public TextField getCourseDeletionField() {
		return courseDeletionField;
	}



	public void setCourseDeletionField(TextField courseDeletionField) {
		this.courseDeletionField = courseDeletionField;
	}



	public Button getCourseDeletionSubmit() {
		return courseDeletionSubmit;
	}



	public void setCourseDeletionSubmit(Button courseDeletionSubmit) {
		this.courseDeletionSubmit = courseDeletionSubmit;
	}



	public RemoveCourseWindow() {
		// Remove course window - Main Pane
		courseDeletionStage = new Stage();
		courseDeletionStage.setTitle("Deleting course");
		VBox courseDeletionPane = new VBox();
		courseDeletionPane.setPadding(new Insets(10));
		// Remove course window - Components
		Label courseDeletionText = new Label("Enter course name to remove: ");
		courseDeletionField = new TextField();
		courseDeletionSubmit = new Button("Submit");
		VBox.setMargin(courseDeletionSubmit, new Insets(5, 0, 5, 0));
		// Remove course window - Stage setting
		courseDeletionPane.getChildren().addAll(courseDeletionText, courseDeletionField, courseDeletionSubmit);
		Scene courseScene = new Scene(courseDeletionPane);
		courseDeletionStage.setScene(courseScene);
		courseDeletionStage.show();
		
		//TODO Logic for deletion.
	}
}
