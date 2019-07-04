package com.example.aplikacjazarzdzaniadlugiem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WyswietlDlugActivity extends AppCompatActivity {

    public  WyswietlDlugAdapter mAdapter;
  // List<Dlugi> listaDlugow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl_dlug);

        //listaDlugow = new ArrayList<>();
        mAdapter = new WyswietlDlugAdapter(this,R.layout.wiersz_dlugi);
        ListView listView = findViewById(R.id.listViewDlugi);
        listView.setAdapter(mAdapter);



        WyswietlDlug wyswietlDlug = new WyswietlDlug (this);
        wyswietlDlug.execute();


    }

    public void aktualizujListeDlugow(List<Dlugi> tmp)
    {
        final List<Dlugi> list = tmp;
        mAdapter.addAll(list);


    }


}

