package com.example.aplikacjazarzdzaniadlugiem;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class WyswietlDlug extends AsyncTask<Void,Void,Void>{

    MobileServiceTable<Dlugi> mDlugiTable;
    private String idZalogowany;
    WyswietlDlugActivity activity ;
    private List<Dlugi> lista;
    public WyswietlDlug (Activity activity){

        idZalogowany =ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmId();
         this.activity = (WyswietlDlugActivity) activity;
         mDlugiTable = ServiceClient.getmInstance().getClient().getTable(Dlugi.class);

    }
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            lista = zwrocDlugiPlus();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        activity.aktualizujListeDlugow(lista);
    }

    public List<Dlugi> zwrocDlugiPlus() throws ExecutionException, InterruptedException {

       return mDlugiTable.where().field("Komu").eq().val(idZalogowany).or().field("Kto").eq().val(idZalogowany).execute().get();
    }

    public List<Dlugi> zwrocDlugiMinus() throws ExecutionException, InterruptedException {

        return mDlugiTable.where().field("Kto").eq().val(idZalogowany).execute().get();
    }

}
