package com.example.jsontoapp.objects;


public class Monitor {

    private int id;
    private String name;
    private String desc;
    private int monitorTypeId;

    public Monitor() {
    }

    public Monitor(int id, String name, String desc, int monitorTypeId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.monitorTypeId = monitorTypeId;
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

}
