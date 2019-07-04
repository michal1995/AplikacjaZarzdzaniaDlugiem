package com.example.aplikacjazarzdzaniadlugiem;

import android.os.AsyncTask;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Statystyki extends AsyncTask<Void,Void,Void> {

    MobileServiceTable<Dlugi> tabelaDlugi;
    List<Dlugi> dlugiLista;
    StatystykiActivity ads;
    public Statystyki(StatystykiActivity saf){

        ads =saf;
        tabelaDlugi = ServiceClient.getmInstance().getClient().getTable(Dlugi.class);
        dlugiLista =new ArrayList<>();
    }
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            dlugiLista = zwrocDlugi();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

        StatystykiActivity textview= ads;
        textview.textViewBilans.setText(String.valueOf(bilansDlug()));
        textview.textViewPlus.setText(String.valueOf(sumujDlug()));
        textview.textViewMinus.setText(String.valueOf(minusDlug()));


    }

    public  List<Dlugi> zwrocDlugi () throws ExecutionException, InterruptedException {
        return tabelaDlugi.where().
                field("Komu").eq().val(ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmId()).
                or().
                field("Kto").eq().val(ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().
                getmId()).execute().get();

   }

   public float sumujDlug()
   {
       float tmp=0;
       for(Dlugi item : dlugiLista)

           if(item.getmKomu().equals(ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmId()))
           tmp += item.getmIle();
       return tmp;

   }

    public float minusDlug()
    {
        float tmp=0;
            for(Dlugi item : dlugiLista)
                if(item.getmKto().equals(ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmId()))
            tmp -= item.getmIle();
        return tmp;

    }
    public float bilansDlug()
    {
        return minusDlug()+sumujDlug();

    }
}
