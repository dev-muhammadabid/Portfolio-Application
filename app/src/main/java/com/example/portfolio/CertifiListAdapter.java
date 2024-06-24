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

public class CertifiListAdapter extends RecyclerView.Adapter<CertifiListAdapter.ViewHolder> {

    private List<CertifiItem> certifiList;
    private Context context;

    public CertifiListAdapter(List<CertifiItem> certifiList, Context context) {
        this.certifiList = certifiList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.certifi_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CertifiItem item = certifiList.get(position);
        holder.certifiLogo.setImageResource(item.getImageResId());
        holder.certifiTitle.setText(item.getTitle());
        holder.certifiDesc.setText(item.getDesc());

        View.OnClickListener listener = v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
            context.startActivity(intent);
        };

        holder.certifiLogo.setOnClickListener(listener);
        holder.certifiTitle.setOnClickListener(listener);
        holder.certifiDesc.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return certifiList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView certifiLogo;
        TextView certifiTitle;
        TextView certifiDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            certifiLogo = itemView.findViewById(R.id.certifi_img);
            certifiTitle = itemView.findViewById(R.id.certifi_title);
            certifiDesc = itemView.findViewById(R.id.certifi_desc);
        }
    }
}
