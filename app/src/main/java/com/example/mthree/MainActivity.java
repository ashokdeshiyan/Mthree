package com.example.mthree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mthree.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

   public boolean show = true;

    Timer timer;
    MyViewPagerAdapter myViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        myViewPagerAdapter = new MyViewPagerAdapter(this);
        binding.viewpagermain.setAdapter(myViewPagerAdapter);


        binding.indicators.setViewPager(binding.viewpagermain);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                binding.viewpagermain.post(new Runnable() {
                    @Override
                    public void run() {
                        if(binding.viewpagermain.getCurrentItem()==3){
                            binding.viewpagermain.setCurrentItem(0);
                        }
                        else {
                            binding.viewpagermain.setCurrentItem((binding.viewpagermain.getCurrentItem() + 1));
                        }
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask,3000,3000);


        binding.dealtodaytext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (show==false){

                    binding.hidenshowable.setVisibility(View.VISIBLE);
                    binding.showhideimage.setImageResource(R.drawable.ic_expand_less_black_24dp);
                    show=true;
                }

                else if (show==true){
                    binding.hidenshowable.setVisibility(View.GONE);
                    binding.showhideimage.setImageResource(R.drawable.ic_expand_more_black_24dp);
                    show=false;

                }
            }
        });


        binding.dealtoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),DealsList.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(),"Deals of The Day",Toast.LENGTH_SHORT).show();
            }
        });
         binding.alldeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"All Deals",Toast.LENGTH_SHORT).show();
            }
        });

         binding.cartbag.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(getApplicationContext(),"Bag Cart",Toast.LENGTH_SHORT).show();
             }
         });


        binding.searchbycategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Search by Category",Toast.LENGTH_SHORT).show();
            }
        });

        binding.searchbyloaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Search by Location",Toast.LENGTH_SHORT).show();
            }
        });

        binding.searchbykeyboad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Search by Keyboard",Toast.LENGTH_SHORT).show();
            }
        });

        binding.searchbyvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Search by Voice",Toast.LENGTH_SHORT).show();
            }
        });


        binding.helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ready To Help you",Toast.LENGTH_LONG).show();
            }
        });

        binding.logsingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.logindialog);
                dialog.setCancelable(true);




                final EditText fname = (EditText) dialog.findViewById(R.id.fnameedittext);
                final TextView errortext = (TextView)dialog.findViewById(R.id.inputerrorname);
                final boolean[] checkinput = new boolean[1];
                final boolean[] testcheckbox = new boolean[1];


                fname.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String fnameval = fname.getText().toString().trim();

                        if (fnameval.length()==0){
                            errortext.setVisibility(View.VISIBLE);
                            checkinput[0] =false;


                        }
                        else if (fnameval.length()>4){
                            errortext.setVisibility(View.INVISIBLE);
                            checkinput[0] =true;


                        }

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });


                final CheckBox checkBox = (CheckBox)dialog.findViewById(R.id.termscheckbox);
                final TextView errorcheck = (TextView)dialog.findViewById(R.id.errorcheckbox);


                Button dialognextbtn = (Button)dialog.findViewById(R.id.nextbtnpressed);


                dialognextbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkinput[0]==false){
                            errortext.setVisibility(View.VISIBLE);

                        }
                        else if (checkBox.isChecked()==false){
                            errorcheck.setVisibility(View.VISIBLE);
                        }
                        else {
                            errortext.setVisibility(View.INVISIBLE);
                            errorcheck.setVisibility(View.INVISIBLE);
//                     TODO: TO next Dialog====

                            dialog.dismiss();
                        }
                    }
                });

                ImageView closseimage = (ImageView)dialog.findViewById(R.id.button_close);
                closseimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                if (dialog.getWindow()!=null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }

                dialog.show();
            }
        });


    }
}
