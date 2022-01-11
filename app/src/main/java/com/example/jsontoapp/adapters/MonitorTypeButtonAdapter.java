package com.example.jsontoapp.adapters;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;
import com.example.jsontoapp.objects.Legends;
import com.example.jsontoapp.objects.Lists;
import com.example.jsontoapp.objects.Monitor;
import com.example.jsontoapp.objects.MonitorType;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MonitorTypeButtonAdapter extends RecyclerView.Adapter<MonitorTypeButtonAdapter.MyViewHolder> {
    private View view;
    private final Lists dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final Button button;
        private final PopupMenu popupMenu;

        public MyViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.btn);
            popupMenu = new PopupMenu(itemView.getContext(), button);
        }
    }

    public MonitorTypeButtonAdapter(Lists data) {
        this.dataSet = data;
    }

    @NonNull
    @Override
    public MonitorTypeButtonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.monitor_type, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // MonitorType Buttons Menu
        final MonitorType monitorType = dataSet.getMonitorTypeList().get(position);
        holder.button.setText(monitorType.getName());

        // Monitor PopUpMenu
        for(int i=0;i<monitorType.getMonitorList().size();i++)
            holder.popupMenu.getMenu().add(Menu.NONE, i, i, monitorType.getMonitorList().get(i).getName());

        holder.button.setOnClickListener(v -> holder.popupMenu.show()); // show Monitor menu

        // when clicking a Monitor -> show Legend in new fragment
        holder.popupMenu.setOnMenuItemClickListener(item -> {

            int id = item.getItemId(); // id of clicked Monitor
            Monitor monitorClicked = monitorType.getMonitorList().get(id);
            Legends legendToShow = monitorClicked.getMonitorLegend();

            Gson gson = new Gson();

            String legendToJsonString = gson.toJson(legendToShow); // Legend to JsonString

            List<String> legendDetails = new ArrayList<>();

            String monitorTypeDesc = dataSet.getMonitorTypeList().get(monitorClicked.getMonitorTypeId()).getDescription();
            if (monitorTypeDesc.equals(""))
                monitorTypeDesc = dataSet.getMonitorTypeList().get(monitorClicked.getMonitorTypeId()).getName();
            legendDetails.add(monitorTypeDesc); // add monitor type description to array

            String monitorDesc = monitorClicked.getDesc();
            if(monitorDesc.equals(""))
                monitorDesc = monitorClicked.getName();
            legendDetails.add(monitorDesc); // add monitor description to array

            legendDetails.add(legendToJsonString); // add Legend string to array

            String legendDetailsToJsonString = gson.toJson(legendDetails); // array of strings to JsonString

            // navigate to destination passing jsonString data
            Bundle bundle = new Bundle();
            bundle.putString("legendToShowInFragment", legendDetailsToJsonString);
            Navigation.findNavController(view).navigate(R.id.action_monitorTypeMenuFragment_to_legendFragment, bundle);

            return false;
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.getMonitorTypeList().size();
    }
}
