package com.example.jsontoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.services.DataService;
import com.example.jsontoapp.R;
import com.example.jsontoapp.adapters.MonitorTypeButtonAdapter;
import com.example.jsontoapp.objects.MonitorType;

import java.util.List;

public class MonitorTypeMenu extends Fragment {
    private List<MonitorType> monitorTypeList;
    private MonitorTypeButtonAdapter buttonAdapter;
    private RecyclerView monitorTypeRV;

    public MonitorTypeMenu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_monitor_type_menu, container, false);

        DataService ds = new DataService(getActivity());
        monitorTypeList = ds.getArrState(); // get JSON data

        monitorTypeRV = v.findViewById(R.id.recycler_view_buttons);
        monitorTypeRV.setHasFixedSize(true);
        monitorTypeRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        buttonAdapter = new MonitorTypeButtonAdapter(getActivity(), monitorTypeList);
        monitorTypeRV.setAdapter(buttonAdapter);

        return v;
    }

}
