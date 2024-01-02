package com.example.androidass2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerViewHolder extends RecyclerView.ViewHolder {
    TextView  textTitle ,textSource;
    ImageView headline_img ;
    CardView cardView ;
    public CustomerViewHolder(@NonNull View itemView) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.textTitle);
        textSource = itemView.findViewById(R.id.textSource);
        cardView= itemView.findViewById(R.id.main_Card);
       headline_img =itemView.findViewById(R.id.img_headline);
    }
}
