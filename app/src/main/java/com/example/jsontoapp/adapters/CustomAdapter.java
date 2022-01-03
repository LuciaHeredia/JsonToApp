package com.example.jsontoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;
import com.example.jsontoapp.objects.MonitorType;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<MonitorType> dataSet;
    private Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        Button button0;
        Button button1;
        Button button2;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.cardView = (CardView) itemView.findViewById(R.id.card_view);
            this.button0 = (Button) itemView.findViewById(R.id.button0);
            this.button1 = (Button) itemView.findViewById(R.id.button1);
            this.button2 = (Button) itemView.findViewById(R.id.button2);

        }
    }

    public CustomAdapter(Context mContext, ArrayList<MonitorType> data) {
        this.mContext = mContext;
        this.dataSet = data;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.monitor_type, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.button0.setText(dataSet.get(position).getDescription());
        holder.button1.setText(dataSet.get(position).getDescription());
        holder.button2.setText(dataSet.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
