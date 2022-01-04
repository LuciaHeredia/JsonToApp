package com.example.jsontoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;
import com.example.jsontoapp.adapters.LegendAdapter;
import com.example.jsontoapp.adapters.MonitorTypeButtonAdapter;

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

        // Legend
        RecyclerView legendRV = v.findViewById(R.id.recycler_view_legend);
        legendRV.setHasFixedSize(true);
        legendRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        LegendAdapter legendAdapter = new LegendAdapter();
        legendRV.setAdapter(legendAdapter);



        return v;
    }




}
