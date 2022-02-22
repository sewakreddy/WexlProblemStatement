package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Street {

    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "[number="+number+",name="+name+"]";
    }
}
