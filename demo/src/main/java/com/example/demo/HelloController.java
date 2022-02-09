package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloController {
    private ObservableList<Record> records = FXCollections.observableArrayList();

    @FXML
    private TextField input;

    @FXML
    private TableView<Record> table;

    @FXML
    private TableColumn<Record, Integer> idColumn;

    @FXML
    private TableColumn<Record, String> dataColumn;

    @FXML
    protected void clearTable(){
        table.getItems().clear();
    }

    int i = 1;

    @FXML
    protected void fillCell(){
        idColumn.setCellValueFactory(new PropertyValueFactory<Record, Integer>("id"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<Record, String>("data"));

        records.add(new Record(i, getInfoFromFile()));
        table.setItems(records);

        i++;
    }

    private String getInfoFromFile(){
        try(FileInputStream fin=new FileInputStream(input.getText()))
        {
            String info = new String();

            int i=-1;
            while((i=fin.read())!=-1){
                info += (char)i;
            }

            return info;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return "";
        }
    }

    //C:\Users\KuratovIA\Desktop\file.txt
}