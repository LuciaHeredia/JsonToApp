package com.example.jsontoapp.objects;

import java.util.List;

public class Monitor {

    int id;
    String name;
    String desc;
    int monitorTypeId;
    private List<Legends> legendsList = null;

    public Monitor(int id, String name, String desc, int monitorTypeId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.monitorTypeId = monitorTypeId;
    }

    public Monitor(int id, String name, String desc, int monitorTypeId, List<Legends> legendsList) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.monitorTypeId = monitorTypeId;
        this.legendsList = legendsList;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getMonitorTypeId() {
        return monitorTypeId;
    }

    public void setMonitorTypeId(int monitorTypeId) {
        this.monitorTypeId = monitorTypeId;
    }

    public List<Legends> getLegendsList() {
        return legendsList;
    }

    public void setLegendsList(List<Legends> legendsList) {
        this.legendsList = legendsList;
    }
}
