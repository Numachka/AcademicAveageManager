# AcademicAverageManager
Academic average calculating app using Java, JavaFX (no FXML), Collections and MVC pattern (plus some math!)

### Explanation
The app is a tool I created for myself to keep track of my courses and academic average.
I tried taking software engineering steps in creating. I decided to use java as it is my current strongest language.
Afterwards Iv'e decided to use and MVC pattern to seperate my class files to keep it clean.
#### Model
The model classes are Student and Course objects. Iv'e decided to put the courses as an ArrayList field in the Student
class so it is iterable, comparable, and also both of them implement Serialzible for simple writing to and loading from a file.
#### View
The view Classes are the JavaFX using windows:
- MainWindow
  The first main window displays the academic credit, academic average, course table and the controller buttons.
- NoStudentAlertWindow
  When the program loads it looks up and tries to load a Student. if there is no student an alert pops up to create one.
  if choosen to create one the CreateStudentWindow pops
- CreateStudentWindow
  pops when we want to create a window. A text field to enter a name and a submit button.
- AddCourseWindow
  The Course creating window, has fields for course details and a submit button.
- RemoveCourseWindow
  The course removing window, a text field to search for a course and a submit button to remove it.
#### Controller
the controller class is the DataController class. It's fields are instances of the buttons and fields around the app to
control the flow of information and keep the MVC principals intact.
