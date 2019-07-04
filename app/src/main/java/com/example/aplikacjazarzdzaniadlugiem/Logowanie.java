package com.example.aplikacjazarzdzaniadlugiem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;



public class Logowanie extends AsyncTask<String,Integer, String>{

    private Context context;
    private TextView debug;

    /*
       Komunikuje proces logowania
     */
    private ProgressDialog progressDialog;

    /*
      Referencja do tabeli pozwalająca na dostęp oraz modyfikacje
     */
    private MobileServiceTable<Uzytkownicy> mUzytkownicyTable;
    /*
      Lista uzytkownikow zwracanych po zapytaniu do bazy danych
     */
    private List<Uzytkownicy> listaUzytkownikow;
    /*
        Przechowuje informacje o zalogowanym użytkowniku
     */
    private Activity aactivity;
    private Intent intentMenu;
    private  List<Uzytkownicy> zalogowany = null;
LoginActivity activity ;



    /**
     * Konstruktor logowanie
     * @param context
     * @param debug
     * @param aactivity
     */
    public Logowanie(Context context, TextView debug, Activity aactivity)
    {
        this.context = context;
        this.debug = debug;
        this.aactivity=aactivity;

        mUzytkownicyTable=ServiceClient.getmInstance().getClient().getTable(Uzytkownicy.class);

    }
    /**
     *Instrukcje  wykonujące sie przed własciwymi instrukcjami logowania
     */
    @Override
    protected void onPreExecute() {
        //progressDialog = new ProgressDialog(this.context);
        progressDialog.setTitle("Logowanie");
        progressDialog.show();
    }

   /* @Override
    protected void onPostExecute(String s) {

    }*/

    /**
     * Metoda logowania działająca w tle
     * @param strings
     * @return
     */
    @SuppressLint("WrongThread")
    @Override
    protected String doInBackground(String... strings) {


        try {
           zalogowany=zwrocDaneLogowania(strings[0], strings[1]);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MobileServiceException e) {
            e.printStackTrace();
        }


        if(!zalogowany.isEmpty()){

            final Uzytkownicy tmp = zalogowany.get(0);
            ZalogowanyUzytkownik.inicjalizacja(tmp);

            intentMenu = new Intent(context,MenuActivity.class);
            aactivity.startActivity(intentMenu);

        }
        else{
           // intentMenu = new Intent(context,LoginActivity.class);
//            Toast.makeText(context,"ads",Toast.LENGTH_LONG).show();
            progressDialog.cancel();
            //debug.setVisibility(View.VISIBLE);
            aactivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    debug.setVisibility(View.VISIBLE);
                }
            });

        }


        return null;
    }

    /**
     * Zwraca zapytanie o
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws MobileServiceException
     */
    private List<Uzytkownicy> zwrocDaneLogowania(String login,String haslo) throws ExecutionException, InterruptedException, MobileServiceException {

        return mUzytkownicyTable.where().field("login").eq().val(login).and().field("haslo").eq().val(haslo).execute().get();
    }
}
