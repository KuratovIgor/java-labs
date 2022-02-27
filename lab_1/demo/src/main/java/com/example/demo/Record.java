package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Record {
    private SimpleIntegerProperty id;
    private SimpleStringProperty data;

    Record(Integer id, String data){
        this.id = new SimpleIntegerProperty(id);
        this.data = new SimpleStringProperty(data);
    }

    public Integer getId(){return id.get();}
    public void setId(Integer id){this.id.set(id);}

    public String getData(){return data.get();}
    public void setData(String data){this.data.set(data);}
}
