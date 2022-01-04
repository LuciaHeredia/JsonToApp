package com.example.jsontoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jsontoapp.objects.Legends;
import com.example.jsontoapp.objects.Lists;
import com.example.jsontoapp.objects.Monitor;
import com.example.jsontoapp.objects.MonitorType;
import com.example.jsontoapp.services.DataService;
import com.example.jsontoapp.R;
import com.example.jsontoapp.adapters.MonitorTypeButtonAdapter;

import java.util.ArrayList;
import java.util.List;

public class MonitorTypeMenu extends Fragment {
    private View v;
    private Lists listOfLists;

    public MonitorTypeMenu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_monitor_type_menu, container, false);

        listOfLists = new Lists();

        DataService ds = new DataService(getActivity());
        listOfLists = ds.getListsData(); // get JSON data

        // Connect Between Lists
        connectLists();

        // MonitorType Buttons Menu
        RecyclerView monitorTypeRV = v.findViewById(R.id.recycler_view_buttons);
        monitorTypeRV.setHasFixedSize(true);
        monitorTypeRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        MonitorTypeButtonAdapter buttonAdapter = new MonitorTypeButtonAdapter(listOfLists);
        monitorTypeRV.setAdapter(buttonAdapter);

        return v;
    }

    private void connectLists() {

        // Monitor TO MonitorType
        for(int i=0;i<listOfLists.getMonitorTypeList().size();i++){
            MonitorType monitorType = listOfLists.getMonitorTypeList().get(i);
            List<Monitor> monitorList = new ArrayList<>();
            for(int j=0;j<listOfLists.getMonitorList().size();j++){
                Monitor monitor = listOfLists.getMonitorList().get(j);
                if(monitor.getMonitorTypeId()==monitorType.getId())
                    monitorList.add(monitor);
            }
            monitorType.setMonitorList(monitorList); // add Monitor list to MonitorType
        }

        // Legend to Monitor by MonitorType_LegendId
        for(int i=0;i<listOfLists.getMonitorList().size();i++){
            Monitor monitor = listOfLists.getMonitorList().get(i);
            int monitorTypeIndex = monitor.getMonitorTypeId();
            MonitorType monitorType = listOfLists.getMonitorTypeList().get(monitorTypeIndex);
            Legends legendToMonitor = listOfLists.getLegendsList().get(monitorType.getLegendId());
            monitor.setMonitorLegend(legendToMonitor); // add Legend to Monitor
        }

    }

}
