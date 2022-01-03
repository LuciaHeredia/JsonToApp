package com.example.jsontoapp.objects;

public class Tags {

    private String label;
    private String color;

    public Tags() {
    }

    public Tags(String label, String color) {
        this.label = label;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
