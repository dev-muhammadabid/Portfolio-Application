package com.example.portfolio;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TechListAdapter extends RecyclerView.Adapter<TechListAdapter.ViewHolder> {

    private List<TechItem> techList;
    private Context context;

    public TechListAdapter(List<TechItem> techList, Context context) {
        this.techList = techList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tech_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TechItem item = techList.get(position);
        holder.techLogo.setImageResource(item.getImageResId());
        holder.techTitle.setText(item.getTitle());

        View.OnClickListener listener = v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
            context.startActivity(intent);
        };

        holder.techLogo.setOnClickListener(listener);
        holder.techTitle.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return techList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView techLogo;
        TextView techTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            techLogo = itemView.findViewById(R.id.tech_img);
            techTitle = itemView.findViewById(R.id.tech_name);
        }
    }
}
