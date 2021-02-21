package com.rl.emulate.cpu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    AnchorPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Parent viewer = FXMLLoader.load(getClass().getResource("hexview.fxml"));
            AnchorPane.setRightAnchor(viewer, 0.0);
            AnchorPane.setTopAnchor(viewer, 0.0);
            AnchorPane.setBottomAnchor(viewer, 0.0);
            root.getChildren().add(viewer);
            AnchorPane pane = new AnchorPane();
            pane.setStyle("-fx-background-color: red;");
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            root.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
