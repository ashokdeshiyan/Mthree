package com.example.mthree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;
import com.zhouyou.view.seekbar.SignSeekBar;

import java.util.ArrayList;
import java.util.Locale;

import static java.security.AccessController.getContext;

public class DealsList extends AppCompatActivity {


    ArrayList<Detaillist> detaillist;

    IndicatorSeekBar seekBarWithProgress;

    ImageView backbutonhome;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    int[] img = {
            R.drawable.shoe1,
            R.drawable.shoe2,
            R.drawable.shoe1,
            R.drawable.shoe2,
    };


    String[] brand = {
            "Brand one",
            "Brand two",
            "Brand three",
            "Brand four",
    };

    String[] off = {
            "40%",
            "45%",
            "50%",
            "55%",
    };



    Button bookbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals_list);

        recyclerView = findViewById(R.id.mainrecyclerview);

        Integer[] ratings = {5,4,3,2};
        String[] offerdetail = {
                "Offer Details",
                "Offer Details",
                "Offer Details",
                "Offer Details",

        };
        String[] erarlybired = {
                "Early bird",
                "Early bird",
                "Early bird",
                "Early bird",


        };
        String[] randomtext = {
                "Random Text",
                "Random Text",
                "Random Text",
                "Random Text",

        };

        String[] butontext={
                "Shortlisted",
                "Shortlisted",
                "Shortlisted",
                "Shortlisted",

        };
        String[] secondbutn={
                "Save 50s ",
                "Save 50s ",
                "Save 50s ",
                "Save 50s ",


        };


        detaillist = new ArrayList<>();
        for (int i=0; i<ratings.length; i++){
            Detaillist detaillist1 = new Detaillist(offerdetail[i],erarlybired[i],randomtext[i],butontext[i],secondbutn[i]);
            detaillist.add(detaillist1);
        }


        recyclerAdapter = new RecyclerAdapter(this, img, brand, off,detaillist);
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(recyclerAdapter);

        backbutonhome = findViewById(R.id.backbtnhome);

         seekBarWithProgress = findViewById(R.id.custom_indicator_by_java_code);
         seekBarWithProgress.setOnSeekChangeListener(new OnSeekChangeListener() {
             @Override
             public void onSeeking(SeekParams seekParams) {

             }

             @Override
             public void onStartTrackingTouch(IndicatorSeekBar seekBar) {



             }

             @Override
             public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
                 if (seekBarWithProgress.getProgress()==0){
                     Toast.makeText(getApplicationContext(),"Deals",Toast.LENGTH_SHORT).show();
                 }else if (seekBarWithProgress.getProgress()==1){
                     Toast.makeText(getApplicationContext(),"Shortlist",Toast.LENGTH_SHORT).show();
                 }
                 else if (seekBarWithProgress.getProgress()==2){
                     Toast.makeText(getApplicationContext(),"Book",Toast.LENGTH_SHORT).show();
                 }
                 else if (seekBarWithProgress.getProgress()==3){
                     Toast.makeText(getApplicationContext(),"Go Shop",Toast.LENGTH_SHORT).show();
                 }
             }
         });


         backbutonhome.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });


    }
}


//TODO: button click o recycler view

class Detaillist{

//    Integer rating;
    String offerdetails;
    String earlybird;
    String randomtext;
    String buttontext;
    String secondbtntxt;

    public Detaillist( String offerdetails, String earlybird, String randomtext, String buttontext, String secondbtntxt){

//        this.rating = rating;
        this.offerdetails=offerdetails;
        this.earlybird=earlybird;
        this.randomtext=randomtext;
        this.buttontext=buttontext;
        this.secondbtntxt=secondbtntxt;
    }

//
//
//    public Integer getRating() {
//        return rating;
//    }

    public String getOfferdetails() {
        return offerdetails;
    }

    public String getEarlybird() {
        return earlybird;
    }

    public String getRandomtext() {
        return randomtext;
    }

    public String getButtontext() {
        return buttontext;
    }

    public String getSecondbtntxt() {
        return secondbtntxt;
    }
}