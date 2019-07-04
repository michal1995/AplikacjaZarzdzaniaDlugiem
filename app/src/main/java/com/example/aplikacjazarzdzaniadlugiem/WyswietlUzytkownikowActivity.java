package com.example.aplikacjazarzdzaniadlugiem;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class WyswietlUzytkownikowActivity extends AppCompatActivity {


    public TextView textView;
    public WyswietlUzytkownika wyswietlUzytkownika;
    public ListView listView;
    public  WyswietlUzytkownikaAdapter mAdapter;

    public List<Uzytkownicy> listaWybranychID;

    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listaWybranychID = new ArrayList<>();
        setContentView(R.layout.activity_wyswietl_uzytkownikow);

        textView = findViewById(R.id.textViewdebug2);
        listView = findViewById(R.id.listViewUsers);
        mAdapter = new WyswietlUzytkownikaAdapter(this,R.layout.wiersz_users);

        //Set Adapter
        listView.setAdapter(mAdapter);
        //Pobieranie uzytkownikow
        wyswietlUzytkownika= new WyswietlUzytkownika(this);
        wyswietlUzytkownika.execute();





    }
    public void onClickDalej(View v)
    {
        if(!listaWybranychID.isEmpty())
        {
            intent = new Intent(this,DodajDlugActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Metoda aktualizujaca liste listę uzytkowników do widoku w,
     * którym wybiera sie osoby do przypisania długu
     *
     * @param tmp lista zwracana przez metode klasy WyswietlUzytkownika
     */

    public void aktualizujListeWybranych(List<Uzytkownicy> tmp)
    {
        final List<Uzytkownicy> listTmp = tmp;
                mAdapter.addAll(listTmp);


    }

    public void dodajDoListyWybranych(Uzytkownicy uzytkownicy)
    {

        listaWybranychID.add(uzytkownicy);
        ZalogowanyUzytkownik.getInstance().dodajElementDoListy(uzytkownicy);
        aktualizujDebug();
    }
    public void usunDoListyWybranych(Uzytkownicy uzytkownicy)
    {
       listaWybranychID.remove(uzytkownicy);
        ZalogowanyUzytkownik.getInstance().usunElementDoListy(uzytkownicy);
       aktualizujDebug();
    }
    public void aktualizujDebug()
    {
         String text = new String("Lista wybranych:");
        for(Uzytkownicy uzytkownicy:listaWybranychID)
            text += uzytkownicy.getmLogin();
    }
}
