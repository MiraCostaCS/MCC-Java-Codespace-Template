package edu.miracosta.cs112.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainController {

    @FXML
    Button hiButton;

    @FXML
    protected void onHelloButtonClicked(ActionEvent actionEvent) {
        System.out.println("Hello World!");
    }
}