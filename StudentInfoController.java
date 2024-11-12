package com.example.takkamcheng_comp228lab4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//public class StudentInfoController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
//}

public class StudentInfoController {

    @FXML private TextField nameField;
    @FXML private TextField addressField;
    @FXML private TextField provinceField;
    @FXML private TextField cityField;
    @FXML private TextField postalCodeField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;

    @FXML private RadioButton csRadio;
    @FXML private RadioButton businessRadio;
    @FXML private ComboBox<String> courseComboBox;
    @FXML private ListView<String> courseListView;

    @FXML private CheckBox studentCouncilCheckBox;
    @FXML private CheckBox volunteerWorkCheckBox;
    @FXML private TextArea displayArea;

    // Add Label for displaying messages
    @FXML private Label messageLabel;

    public void initialize() {
        // Initialize course combo box
        courseComboBox.getItems().addAll("Java", "Python", "C#");

        // Add listener to combo box for course selection
        courseComboBox.setOnAction(event -> addCourse());
    }

    private void addCourse() {
        String selectedCourse = courseComboBox.getValue();
        if (selectedCourse != null && !courseListView.getItems().contains(selectedCourse)) {
            courseListView.getItems().add(selectedCourse);
            messageLabel.setText("Course added: " + selectedCourse);
        } else {
            messageLabel.setText("Course already added or not selected.");
        }
    }

    @FXML
    private void displayStudentInfo() {
        if (nameField.getText().isEmpty() || emailField.getText().isEmpty()) {
            messageLabel.setText("Please enter all required fields.");
            return;
        }

        StringBuilder info = new StringBuilder();
        info.append(nameField.getText()).append(", ")
                .append(addressField.getText()).append(", ")
                .append(cityField.getText()).append(", ")
                .append(provinceField.getText()).append(", ")
                .append(postalCodeField.getText()).append(", ")
                .append(phoneField.getText()).append(", ")
                .append(emailField.getText()).append("\n");

        String major = csRadio.isSelected() ? "Computer Science" : "Business";
        info.append("Major: ").append(major).append("\n");

        info.append("Activities: ");
        if (studentCouncilCheckBox.isSelected()) info.append("Student Council ");
        if (volunteerWorkCheckBox.isSelected()) info.append("Volunteer Work ");
        info.append("\n");

        info.append("Courses:\n");
        courseListView.getItems().forEach(course -> info.append(course).append("\n"));

        displayArea.setText(info.toString());
        messageLabel.setText("Student information displayed successfully.");
    }
}