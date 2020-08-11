package view;

import model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow {
	
	//Controller Contacting Fields
	//Main Window - Primary Stage
	Stage primaryStage;
	//Main Window - Welcome labels
	private Label studentName;
	private Label academicCredits;
	private Label academicAverage;
	//Main Window - Control buttons
	private Button add;
	private Button remove;
	private Button exit;
	//Main Window - Course Table
	ObservableList<Course> observableCourseTable;
	TableView<Course> courseTable;
	
	
	@SuppressWarnings("unchecked")
	public MainWindow() {
		// Main window - Primary pane
		primaryStage = new Stage();
		primaryStage.setTitle("Academic Average");
		GridPane primaryPane = new GridPane();
		primaryPane.setPadding(new Insets(15));
		ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();
		column1.setPercentWidth(70);
		column2.setPercentWidth(30);
		RowConstraints row1 = new RowConstraints();
		RowConstraints row2 = new RowConstraints();
		row1.setPercentHeight(20);
		row2.setPercentHeight(80);
		primaryPane.getColumnConstraints().addAll(column1, column2);
		primaryPane.getRowConstraints().addAll(row1, row2);
		primaryPane.setGridLinesVisible(false);

		// Main window - Student data pane
		FlowPane studentPane = new FlowPane();
		studentName = new Label("Welcome ");
		academicCredits = new Label("Academic Credits: ");
		academicAverage = new Label("Academic Average: ");
		studentPane.setOrientation(Orientation.VERTICAL);
		GridPane.setConstraints(studentPane, 0, 0);
		studentPane.setPadding(new Insets(5));
		studentPane.getChildren().addAll(studentName, academicCredits, academicAverage);

		// Main window - Course list pane
		observableCourseTable = FXCollections.observableArrayList();
		courseTable = new TableView<>();
		courseTable.setEditable(true); // TODO make it work using a button.
		TableColumn<Course, Double> creditColumn = new TableColumn<>("Credits");
		creditColumn.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.2));
		creditColumn.setResizable(false);
		creditColumn.setCellValueFactory(new PropertyValueFactory<Course, Double>("credit"));
		TableColumn<Course, String> courseNameColumn = new TableColumn<>("Course Name");
		courseNameColumn.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.6));
		courseNameColumn.setResizable(false);
		courseNameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
		TableColumn<Course, Double> gradeColumn = new TableColumn<>("Grade");
		gradeColumn.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.2));
		gradeColumn.setResizable(false);
		gradeColumn.setCellValueFactory(new PropertyValueFactory<Course, Double>("grade"));
		courseTable.setItems(observableCourseTable);
		courseTable.getColumns().setAll(creditColumn, courseNameColumn, gradeColumn);
		courseTable.setEditable(false);
		GridPane.setMargin(courseTable, new Insets(5));
		GridPane.setConstraints(courseTable, 0, 1);

		// Main window - Controls pane
		VBox controlPane = new VBox();
		controlPane.setPrefWidth(130);
		add = new Button("Add Course");
		remove = new Button("Remove Course");
		exit = new Button("Exit");
		add.setMinWidth(controlPane.getPrefWidth());
		remove.setMinWidth(controlPane.getPrefWidth());
		exit.setMinWidth(controlPane.getPrefWidth());
		VBox.setMargin(add, new Insets(5));
		VBox.setMargin(remove, new Insets(5));
		VBox.setMargin(exit, new Insets(5));
		GridPane.setConstraints(controlPane, 1, 0);
		GridPane.setRowSpan(controlPane, 2);
		controlPane.setAlignment(Pos.TOP_CENTER);
		controlPane.getChildren().addAll(add, remove, exit);

		// Main window - Scene building
		primaryPane.getChildren().addAll(studentPane, courseTable, controlPane);
		Scene scene = new Scene(primaryPane, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public Label getStudentName() {
		return studentName;
	}

	public void setStudentName(Label studentName) {
		this.studentName = studentName;
	}

	public Label getAcademicCredits() {
		return academicCredits;
	}

	public void setAcademicCredits(Label academicCredits) {
		this.academicCredits = academicCredits;
	}

	public Label getAcademicAverage() {
		return academicAverage;
	}

	public void setAcademicAverage(Label academicAverage) {
		this.academicAverage = academicAverage;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}
	
	public Button getRemove() {
		return remove;
	}

	public void setRemove(Button remove) {
		this.remove = remove;
	}

	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}
	
	public ObservableList<Course> getObservableCourseTable() {
		return observableCourseTable;
	}

	public void setObservableCourseTable(ObservableList<Course> observableCourseTable) {
		this.observableCourseTable = observableCourseTable;
	}

	public TableView<Course> getCourseTable() {
		return courseTable;
	}

	public void setCourseTable(TableView<Course> courseTable) {
		this.courseTable = courseTable;
	}

}
