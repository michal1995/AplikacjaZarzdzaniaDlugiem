package com.example.aplikacjazarzdzaniadlugiem;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PotwierdzDlugActivity extends AppCompatActivity {

    public ListView listView;
    public  PotwierdzDlugAdapter mAdapter;
    public List<Dlugi> listaWybranychDlugow;
    public PotwierdzDlug potwierdzDlug;
    public PotwierdzDlugActivity instanceThisActiviti;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potwierdz_dlug);
        instanceThisActiviti=this;


            listaWybranychDlugow= new ArrayList<>();


            listView = findViewById(R.id.listViewPotwierdzenie);
            mAdapter = new PotwierdzDlugAdapter(this,R.layout.wiersz_komu);


            //Set Adapter
            listView.setAdapter(mAdapter);
        potwierdzDlug = new PotwierdzDlug(this);
        potwierdzDlug.execute();



        //Pobieranie uzytkownikow
        Switch switchSP = findViewById(R.id.switchSP);
        switchSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PotwierdzDlug  tmp = new PotwierdzDlug(instanceThisActiviti);
                tmp.execute();




            }
        });



        }

       public void fuzjaPotwierdzDlugActivity(List<Dlugi> tmp) {
           final List<Dlugi> tmplista = tmp;
           mAdapter.clear();
           mAdapter.addAll( tmplista );
       }

       public void aktualizujListe (Dlugi item){
        potwierdzDlug.aktulizujItem(item);
        mAdapter.remove(item);
       }



}



