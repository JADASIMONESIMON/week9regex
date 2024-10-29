module org.example.week_09_regexassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.week_09_regexassignment to javafx.fxml;
    exports org.example.week_09_regexassignment;
}