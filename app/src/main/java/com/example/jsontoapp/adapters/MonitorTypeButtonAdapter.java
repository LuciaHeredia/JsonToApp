package com.example.jsontoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;
import com.example.jsontoapp.objects.Lists;
import com.example.jsontoapp.objects.MonitorType;


public class MonitorTypeButtonAdapter extends RecyclerView.Adapter<MonitorTypeButtonAdapter.MyViewHolder> {
    private Lists dataSet;
    private Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private Button button;
        private PopupMenu popupMenu;

        public MyViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.btn);
            popupMenu = new PopupMenu(itemView.getContext(), button);
        }
    }

    public MonitorTypeButtonAdapter(Context mContext, Lists data) {
        this.mContext = mContext;
        this.dataSet = data;
    }

    @NonNull
    @Override
    public MonitorTypeButtonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.monitor_type, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final MonitorType type = dataSet.getMonitorTypeList().get(position);
        holder.button.setText(type.getName());

        /* change with JSON MONITOR MENU */
        holder.popupMenu.getMenu().add(Menu.NONE,0,0,"Copy");
        holder.popupMenu.getMenu().add(Menu.NONE,1,1,"Share");
        /* ************ */

        holder.button.setOnClickListener(v -> holder.popupMenu.show()); // show Monitor menu

/*
        holder.popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if(id==0){
                    //COPY CLICKED
                }
                    return false;
            }
        });
        */

    }


    @Override
    public int getItemCount() {
        return dataSet.getMonitorTypeList().size();
    }
}
