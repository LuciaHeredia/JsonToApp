package com.example.jsontoapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;

public class LegendAdapter extends RecyclerView.Adapter<LegendAdapter.LegendViewHolder> {

    public static class LegendViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;

        public LegendViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_name);
        }
    }

    @NonNull
    @Override
    public LegendAdapter.LegendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.legend_row, parent, false);
        return new LegendAdapter.LegendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LegendAdapter.LegendViewHolder holder, int position) {
        holder.title.setText("legend describe");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
