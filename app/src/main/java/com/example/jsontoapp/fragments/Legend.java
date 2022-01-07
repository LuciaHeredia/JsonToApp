package com.example.jsontoapp.fragments;

import android.os.Bundle;
import android.util.Log;
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

        // set Title of Legend(=MonitorName)
        String title = legendDetails.get(0);
        TextView legendTitle = v.findViewById(R.id.text_name);
        legendTitle.setText(title);

        // get Legend details to show
        String jsonStringToLegend = legendDetails.get(1);
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
