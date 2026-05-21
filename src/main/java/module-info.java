module edu.miracosta.cs112 {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.miracosta.cs112 to javafx.fxml;
    exports edu.miracosta.cs112;
    exports edu.miracosta.cs112.models;
    opens edu.miracosta.cs112.models to javafx.fxml;
    exports edu.miracosta.cs112.controllers;
    opens edu.miracosta.cs112.controllers to javafx.fxml;
}