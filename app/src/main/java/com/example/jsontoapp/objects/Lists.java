package com.example.jsontoapp.objects;

import java.util.List;

public class Lists {

    private List<MonitorType> monitorTypeList = null;
    private List<Monitor> monitorList = null;
    private List<Legends> legendsList = null;

    public Lists() {
    }

    public List<MonitorType> getMonitorTypeList() {
        return monitorTypeList;
    }

    public void setMonitorTypeList(List<MonitorType> monitorTypeList) {
        this.monitorTypeList = monitorTypeList;
    }

    public List<Monitor> getMonitorList() {
        return monitorList;
    }

    public void setMonitorList(List<Monitor> monitorList) {
        this.monitorList = monitorList;
    }

    public List<Legends> getLegendsList() {
        return legendsList;
    }

    public void setLegendsList(List<Legends> legendsList) {
        this.legendsList = legendsList;
    }
}
