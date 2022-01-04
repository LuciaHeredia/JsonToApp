package com.example.jsontoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.objects.Lists;
import com.example.jsontoapp.services.DataService;
import com.example.jsontoapp.R;
import com.example.jsontoapp.adapters.MonitorTypeButtonAdapter;

public class MonitorTypeMenu extends Fragment {

    public MonitorTypeMenu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_monitor_type_menu, container, false);

        Lists listOfLists = new Lists();

        DataService ds = new DataService(getActivity());
        listOfLists = ds.getListsData(); // get JSON data

        // MonitorType Buttons Menu
        RecyclerView monitorTypeRV = v.findViewById(R.id.recycler_view_buttons);
        monitorTypeRV.setHasFixedSize(true);
        monitorTypeRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        MonitorTypeButtonAdapter buttonAdapter = new MonitorTypeButtonAdapter(getActivity(), listOfLists);
        monitorTypeRV.setAdapter(buttonAdapter);


        return v;
    }

}
