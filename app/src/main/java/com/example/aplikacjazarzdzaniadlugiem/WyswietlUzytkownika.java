package com.example.aplikacjazarzdzaniadlugiem;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class WyswietlUzytkownika extends AsyncTask<String,String, List<Uzytkownicy>> {



    private MobileServiceTable<Uzytkownicy> mUzytkownicyTable;
    private WyswietlUzytkownikaAdapter mAdapter;
    private WyswietlUzytkownikowActivity activity;
    private List<Uzytkownicy> listaUzytkownicyTmp;


    public WyswietlUzytkownika(Activity activity){

        mUzytkownicyTable=ServiceClient.getmInstance().getClient().getTable(Uzytkownicy.class);
        this.activity=(WyswietlUzytkownikowActivity) activity;




    }

    @Override
    protected List<Uzytkownicy> doInBackground(String... strings) {

        try {
            listaUzytkownicyTmp = WyswietlUzytkownikow();
        } catch (MobileServiceException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(List<Uzytkownicy> uzytkownicies) {
        activity.aktualizujListeWybranych(listaUzytkownicyTmp);
    }


    private List<Uzytkownicy> WyswietlUzytkownikow() throws MobileServiceException, ExecutionException, InterruptedException {
       return mUzytkownicyTable.execute().get();
    }





}
