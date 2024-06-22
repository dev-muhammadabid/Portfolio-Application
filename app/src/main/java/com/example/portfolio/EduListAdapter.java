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

public class EduListAdapter extends RecyclerView.Adapter<EduListAdapter.ViewHolder> {

    private List<EduItem> eduList;
    private Context context;

    public EduListAdapter(List<EduItem> eduList, Context context) {
        this.eduList = eduList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edu_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EduItem item = eduList.get(position);
        holder.eduLogo.setImageResource(item.getImageResId());
        holder.eduTitle.setText(item.getTitle());
        holder.eduDesc.setText(item.getDesc());

        View.OnClickListener listener = v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
            context.startActivity(intent);
        };

        holder.eduLogo.setOnClickListener(listener);
        holder.eduTitle.setOnClickListener(listener);
        holder.eduDesc.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return eduList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView eduLogo;
        TextView eduTitle;
        TextView eduDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eduLogo = itemView.findViewById(R.id.edu_img);
            eduTitle = itemView.findViewById(R.id.edu_title);
            eduDesc = itemView.findViewById(R.id.edu_desc);
        }
    }
}
