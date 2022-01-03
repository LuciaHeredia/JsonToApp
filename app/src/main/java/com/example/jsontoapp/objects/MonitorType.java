package com.example.jsontoapp.objects;

public class MonitorType {

    private int id;
    private String name;
    private int legendId;
    private String description;

    public MonitorType() {
    }

    public MonitorType(int id, String name, int legendId, String description) {
        this.id = id;
        this.name = name;
        this.legendId = legendId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegendId() {
        return legendId;
    }

    public void setLegendId(int legendId) {
        this.legendId = legendId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
