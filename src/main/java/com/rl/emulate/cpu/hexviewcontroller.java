package com.rl.emulate.cpu;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class hexviewcontroller implements Initializable {

    @FXML
    TableView viewer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            configureHexView(viewer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(byte[] memory){
        //for(int i = 0; i < memory.length/16; i++){
        //    viewer.getColumns().get(0);
        //}

    }
    private void configureHexView(Parent root) throws IOException {
        TableView<DataRow> table = (TableView<DataRow>) root.lookup("#hextable");
        table.setContextMenu(new ContextMenu(new MenuItem("Copy"), new MenuItem("Cut"), new MenuItem("Delete")));
        table.getSelectionModel().setCellSelectionEnabled(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableListWrapper<DataRow> wrapper = (ObservableListWrapper<DataRow>) table.itemsProperty().get();

        FileInputStream fis = new FileInputStream("test.bin");
        byte[] input = new byte[16];
        int num = 0;
        int addr = 0;
        while ((num = fis.read(input)) > 0) {
            wrapper.add(new DataRow(addr += 16, input));
        }
        table.getColumns().forEach(c -> {
            c.setStyle("-fx-alignment: CENTER;");
            c.setSortable(false);
        });
        table.getColumns().get(0).setStyle("-fx-alignment: CENTER-RIGHT;");
        table.getColumns().get(17).setStyle("-fx-alignment: CENTER-LEFT;");
    }


}
