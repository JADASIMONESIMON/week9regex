package org.example.week_09_regexassignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private TextField dob;

    @FXML
    private TextField email;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField zipcode;

    @FXML
    private Button addButton;

    @FXML
    private Label fnameLabel, lnameLabel, emailLabel, dobLabel, zipcodeLabel;

    // Regex patterns
    private static final String NAME_REGEX = "^[A-Za-z]{2,25}$";
    private static final String DOB_REGEX = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@farmingdale.edu$";
    private static final String ZIP_CODE_REGEX = "^\\d{5}$";

    @FXML
    public void initialize() {
        setupValidationListeners();
        updateAddButtonState();
    }

    private void setupValidationListeners() {
        // Validate each field on focus loss and show feedback in labels
        fname.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateField(fname, fnameLabel, NAME_REGEX, "Invalid First Name");
        });
        lname.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateField(lname, lnameLabel, NAME_REGEX, "Invalid Last Name");
        });
        email.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateField(email, emailLabel, EMAIL_REGEX, "Invalid Email");
        });
        dob.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateField(dob, dobLabel, DOB_REGEX, "Invalid Date of Birth");
        });
        zipcode.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateField(zipcode, zipcodeLabel, ZIP_CODE_REGEX, "Invalid Zip Code");
        });
    }

    private void validateField(TextField field, Label feedbackLabel, String regex, String errorMessage) {
        // Validates the field content and updates the feedback label
        if (!field.getText().matches(regex)) {
            feedbackLabel.setText(errorMessage);
        } else {
            feedbackLabel.setText("Valid");
        }
        updateAddButtonState();
    }

    private void updateAddButtonState() {
        // Enables the "Add" button only if all fields are valid
        boolean allValid = fname.getText().matches(NAME_REGEX) &&
                lname.getText().matches(NAME_REGEX) &&
                email.getText().matches(EMAIL_REGEX) &&
                dob.getText().matches(DOB_REGEX) &&
                zipcode.getText().matches(ZIP_CODE_REGEX);
        addButton.setDisable(!allValid);
    }

    @FXML
    public void handleAddButton() {
        if (!addButton.isDisable()) {
            showAlert("Success", "Registration completed successfully!");
            navigateToNewUI();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Navigates to the new user interface after successful registration.
     * This method should contain the logic to switch to another screen or display
     * the next stage in the user registration process.
     *
     * @throws Exception if navigation fails due to loading issues or missing resources.
     */
    private void navigateToNewUI() {
        // Implement navigation logic to the new screen
    }
}
