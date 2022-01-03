package com.example.jsontoapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;
import com.example.jsontoapp.objects.MonitorType;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<MonitorType> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        Button button;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.cardView = (CardView) itemView.findViewById(R.id.card_view);
            this.button = (Button) itemView.findViewById(R.id.button_description);

        }
    }

    public CustomAdapter(ArrayList<MonitorType> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.monitor_type, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Button button = holder.button;
        CardView cardView = holder.cardView;

        button.setText(dataSet.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
