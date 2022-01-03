package com.example.jsontoapp.objects;

import java.util.List;

public class MonitorType {

    int id;
    String name;
    int legendId;
    String description;
    private List<Monitor> monitors = null;

    public MonitorType() {
    }

    public MonitorType(int id, String name, int legendId, String description) {
        this.id = id;
        this.name = name;
        this.legendId = legendId;
        this.description = description;
    }

    public MonitorType(int id, String name, int legendId, String description, List<Monitor> monitors) {
        this.id = id;
        this.name = name;
        this.legendId = legendId;
        this.description = description;
        this.monitors = monitors;
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

    public List<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(List<Monitor> monitors) {
        this.monitors = monitors;
    }
}
