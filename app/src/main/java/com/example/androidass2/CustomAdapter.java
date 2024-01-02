package com.example.androidass2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidass2.javaClass.NewsHedlines;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomerViewHolder> {
    private Context context;
    private List<NewsHedlines> hedlines ;
    private  SelectListner listner;
    public CustomAdapter(Context context, List<NewsHedlines> hedlines,SelectListner listner) {
        this.context = context;
        this.hedlines = hedlines;
        this.listner =listner;
    }

    public CustomAdapter(ArrayList<NewsHedlines> arrayList, Context applicationContext) {

    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomerViewHolder(LayoutInflater.from(context).inflate(R.layout.list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
    holder.textTitle.setText(hedlines.get(position).getTitle());
    holder.textSource.setText(hedlines.get(position).getSource().getName());
    if(hedlines.get(position).getUrlToImage()!=null){
        Picasso.get().load(hedlines.get(position).getUrlToImage()).into(holder.headline_img);
    }
    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listner.onNEwsCliced(hedlines.get(position));
            listner.onCionCliced(hedlines.get(position));

        }
    });
    }

    @Override
    public int getItemCount() {
        return hedlines.size() ;
    }
}
