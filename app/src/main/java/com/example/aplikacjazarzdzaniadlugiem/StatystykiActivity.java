package com.example.aplikacjazarzdzaniadlugiem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StatystykiActivity extends AppCompatActivity {
Statystyki statystyki;
    TextView textViewPlus;
    TextView textViewMinus;
    TextView textViewBilans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statystyki);

        statystyki=new Statystyki(this);
        statystyki.execute();

         textViewPlus=findViewById(R.id.textViewDlugPlus);
         textViewMinus=findViewById(R.id.textViewDlugMinus);
         textViewBilans=findViewById(R.id.textViewBilans);

    }


}
