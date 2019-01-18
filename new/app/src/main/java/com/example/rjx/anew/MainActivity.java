package com.example.rjx.anew;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 =findViewById(R.id.b1);
        final TextView tv1 =findViewById(R.id.tv1);
        Switch sw =findViewById(R.id.sw);
        SeekBar sb =findViewById(R.id.sb);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                tv1.setText("You are right!");
                Log.d( "MainActivity", "click");
            }
        });
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    SpannableString ss = new SpannableString("Color");
                    ss.setSpan(new BackgroundColorSpan(Color.BLUE), 0, 5, 0);
                    tv1.setText(ss);
                    Log.d( "MainActivity", "switch");
                }else {
                    tv1.setText("No Color");
                }
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);
                Log.d("MainActivity","BarChanged=" +progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("MainActivity","StartBar");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("MainActivity","StopBar");
            }
        });

        Log.d("MainActivity","end");
    }
}
