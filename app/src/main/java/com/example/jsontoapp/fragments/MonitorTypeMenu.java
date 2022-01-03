package com.example.jsontoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;
import com.example.jsontoapp.adapters.CustomAdapter;
import com.example.jsontoapp.objects.MonitorType;

import java.util.ArrayList;
import java.util.List;

public class MonitorTypeMenu extends Fragment {
    private ArrayList<MonitorType> monitorTypeList;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;

    public MonitorTypeMenu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //GetDataService ds = new GetDataService(getActivity());
        View v =  inflater.inflate(R.layout.fragment_monitor_type_menu, container, false);

        recyclerView = v.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        monitorTypeList = new ArrayList<>();

        MonitorType type = new MonitorType(0,"name","legendid","description");
        monitorTypeList.add(type);

        MonitorType type2 = new MonitorType(1,"name","legendid","description2");
        monitorTypeList.add(type2);

        //monitorTypeList = ds.getMonitorTypeData();

        customAdapter = new CustomAdapter(monitorTypeList);
        recyclerView.setAdapter(customAdapter);

        return v;
    }

}
