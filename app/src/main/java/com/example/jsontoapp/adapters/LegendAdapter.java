package com.example.jsontoapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontoapp.R;
import com.example.jsontoapp.objects.Tags;

import java.util.List;

public class LegendAdapter extends RecyclerView.Adapter<LegendAdapter.LegendViewHolder> {
    private View view;
    private final List<Tags> tags;

    public static class LegendViewHolder extends RecyclerView.ViewHolder {
        private final TextView color;
        private final TextView label;

        public LegendViewHolder(View itemView) {
            super(itemView);
            color = itemView.findViewById(R.id.text_tag_color);
            label = itemView.findViewById(R.id.text_tag_label);
        }
    }

    public LegendAdapter(List<Tags> tags) {
        this.tags = tags;
    }

    @NonNull
    @Override
    public LegendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.legend_row, parent, false);
        return new LegendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LegendViewHolder holder, final int position) {
        TextView textViewColor = holder.color;
        TextView textViewLabel= holder.label;

        textViewColor.setText(tags.get(position).getColor());
        textViewLabel.setText(tags.get(position).getLabel());
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}
