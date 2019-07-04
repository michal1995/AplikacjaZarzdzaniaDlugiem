package com.example.aplikacjazarzdzaniadlugiem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onClickDodajDlug (View view ){

        startActivity(new Intent(this,WyswietlUzytkownikowActivity.class));

    }
    public void onClickWyswietlDlug (View view ){

        startActivity(new Intent(this,WyswietlDlugActivity.class));

    }
    public void onClickPotwierdzlDlug (View view ) {

        startActivity(new Intent(this, PotwierdzDlugActivity.class));
    }
        public void onClickStatystyki (View view ){

            startActivity(new Intent(this,StatystykiActivity.class));


    }
}
