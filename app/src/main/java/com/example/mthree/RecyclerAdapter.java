package com.example.mthree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Detaillist> detaillist;

    Context context;
    int[] images, ratings;
    String branddata[], offdata[];
    public RecyclerAdapter(Context context1, int[] imgs, String[] branddata1, String[] offdata1, ArrayList<Detaillist> dealsLists) {
        this.branddata = branddata1;
        this.images = imgs;
        this.context = context1;
        this.offdata = offdata1;
        this.detaillist=dealsLists;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycleritem,parent,false);
        return  new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mainimage.setImageResource(images[position]);
        holder.offtext.setText(offdata[position]);
        holder.brandtext.setText(branddata[position]);
//        holder.ratingBar.setNumStars(detaillist.get(position).getRating());
        holder.earlybird.setText(detaillist.get(position).getEarlybird());
        holder.randomtext.setText(detaillist.get(position).getRandomtext());
        holder.offerdetail.setText(detaillist.get(position).getOfferdetails());
        holder.btntext.setText(detaillist.get(position).getButtontext());
        holder.secondbtn.setText(detaillist.get(position).getSecondbtntxt());

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {



//        RatingBar ratingBar;
        TextView brandtext, offtext, randomtext, earlybird,offerdetail,secondbtn;
        Button btntext;
        ImageView mainimage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            btntext = itemView.findViewById(R.id.button);
            offerdetail = itemView.findViewById(R.id.tvofferdetails);
            earlybird = itemView.findViewById(R.id.textView3);
            brandtext = itemView.findViewById(R.id.Brandrecycler);
            offtext = itemView.findViewById(R.id.offtext);
            mainimage = itemView.findViewById(R.id.recycleimage);
//            ratingBar =(RatingBar) itemView.findViewById(R.id.ratingBar);
            randomtext = itemView.findViewById(R.id.randpomtext);
            secondbtn = itemView.findViewById(R.id.textView4);



        }
    }
}
