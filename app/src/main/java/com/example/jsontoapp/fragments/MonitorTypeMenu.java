package com.example.jsontoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.jsontoapp.services.DataService;
import com.example.jsontoapp.R;
import com.example.jsontoapp.adapters.CustomAdapter;
import com.example.jsontoapp.objects.MonitorType;

import java.util.List;

public class MonitorTypeMenu extends Fragment {
    private List<MonitorType> monitorTypeList;
    private CustomAdapter customAdapter;

    public MonitorTypeMenu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DataService ds = new DataService(getActivity()); // get JSON data
        View v =  inflater.inflate(R.layout.fragment_monitor_type_menu, container, false);

        monitorTypeList = ds.getArrState();

        Button button0 = (Button) v.findViewById(R.id.button0);
        Button button1 = (Button) v.findViewById(R.id.button1);
        Button button2 = (Button) v.findViewById(R.id.button2);
        button0.setText(monitorTypeList.get(0).getName());
        button1.setText(monitorTypeList.get(1).getName());
        button2.setText(monitorTypeList.get(2).getName());

        return v;
    }

}
