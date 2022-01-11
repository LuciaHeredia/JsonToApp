package com.example.jsontoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jsontoapp.R;
import com.example.jsontoapp.adapters.LegendAdapter;
import com.example.jsontoapp.objects.Legends;
import com.google.gson.Gson;

import java.util.List;

public class Legend extends Fragment {

    public Legend() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_legend, container, false);

        Gson gson = new Gson();

        assert getArguments() != null;
        String jsonStringToList = getArguments().getString("legendToShowInFragment");
        List<String> legendDetails = gson.fromJson(jsonStringToList, List.class);

        // set Monitor Type Title of Legend(=MonitorTypeName)
        String monitorTypeTitle = legendDetails.get(0);
        TextView legendMonitorTypeTitle = v.findViewById(R.id.text_monitor_type_desc);
        legendMonitorTypeTitle.setText(monitorTypeTitle);

        // set Monitor Title of Legend(=MonitorName)
        String monitorTitle = legendDetails.get(1);
        TextView legendMonitorTitle = v.findViewById(R.id.text_monitor_desc);
        legendMonitorTitle.setText(monitorTitle);

        // get Legend details to show
        String jsonStringToLegend = legendDetails.get(2);
        Legends legend = gson.fromJson(jsonStringToLegend, Legends.class);

        // Show Legend
        RecyclerView legendRV = v.findViewById(R.id.recycler_view_legend);
        legendRV.setHasFixedSize(true);
        legendRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        LegendAdapter legendAdapter = new LegendAdapter(legend.getTags());
        legendRV.setAdapter(legendAdapter);

        return v;
    }




}
