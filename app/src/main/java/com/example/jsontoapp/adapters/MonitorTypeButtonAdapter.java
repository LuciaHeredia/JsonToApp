package com.example.jsontoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;
import com.example.jsontoapp.objects.MonitorType;

import java.util.List;

public class MonitorTypeButtonAdapter extends RecyclerView.Adapter<MonitorTypeButtonAdapter.MyViewHolder> {
    private List<MonitorType> dataSet;
    private Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private Button button;

        public MyViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.btn);
        }
    }

    public MonitorTypeButtonAdapter(Context mContext, List<MonitorType> data) {
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
        final MonitorType type = dataSet.get(position);
        holder.button.setText(type.getName());
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
