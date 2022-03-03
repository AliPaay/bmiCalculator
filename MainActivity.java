package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    android.widget.Button mcalculatebmi;

    TextView mcurrentheight;
    TextView mcurrentage, mcurrentweight;
    ImageView mincrementage, mincrementweight, mdecrementage, mdecrementweight;
    SeekBar mseekbarforheight;
    RelativeLayout mmale, mfemale;

    int intweight = 55;
    int intage = 22;
    int currentprogress;
    String mintprogress = "170";
    String typeofuser= "0";
    String weight2 = "55";
    String age2 = "22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        mcalculatebmi = findViewById(R.id.calculatebmi);
        mcurrentage = findViewById(R.id.currentage);
        mcurrentheight = findViewById(R.id.currentheight);
        mcurrentweight = findViewById(R.id.currentweight);
        mincrementage = findViewById(R.id.incrementage);
        mdecrementage = findViewById(R.id.decrementage);
        mincrementweight = findViewById(R.id.incrementweight);
        mdecrementweight = findViewById(R.id.decrementweight);
        mseekbarforheight = findViewById(R.id.seekbarforheight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "Female";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                 currentprogress = i;
                 mintprogress = String.valueOf(currentprogress);
                 mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage+1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage-1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight+1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight-1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });





        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select your gender First!", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select your height First!", Toast.LENGTH_SHORT).show();
                }
                else if (intage == 0 || intage<0){
                    Toast.makeText(getApplicationContext(), "Age is incorrect!", Toast.LENGTH_SHORT).show();
                }
                else if( intweight == 0 || intweight<0){
                    Toast.makeText(getApplicationContext(), "Weight is incorrect!", Toast.LENGTH_SHORT).show();
                }
                else{

                    Intent in = new Intent(MainActivity.this, bmiCalc.class);
                    in.putExtra("gender",typeofuser);
                    in.putExtra("Height",mintprogress);
                    in.putExtra("Weight",weight2);
                    in.putExtra("Age", age2);

                    startActivity(in);
                    finish();
                }





            }
        });
    }
}