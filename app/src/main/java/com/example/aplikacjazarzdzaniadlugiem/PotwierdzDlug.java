package com.example.aplikacjazarzdzaniadlugiem;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Switch;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class PotwierdzDlug extends AsyncTask<Void,Void,Void>{

    MobileServiceTable<Dlugi> mDlugiTable;
    PotwierdzDlugActivity activity;
    String idZalogowany;
    List<Dlugi> listaDlugow;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            listaDlugow = zwrocDlugi();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }


    public PotwierdzDlug(Activity activity){
        this.activity= (PotwierdzDlugActivity) activity;

        mDlugiTable = ServiceClient.getmInstance().getClient().getTable(Dlugi.class);

        idZalogowany = ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmId();

    }
    @Override
    protected void onPostExecute(Void aVoid) {


        activity.fuzjaPotwierdzDlugActivity(listaDlugow);
    }


    public List<Dlugi> zwrocDlugi() throws ExecutionException, InterruptedException {
        Switch przelacznik= activity.findViewById(R.id.switchSP);

        if(przelacznik.isChecked())
        {

        return mDlugiTable.where().field("Kto").eq().val(idZalogowany).and().
                field("Potwierdzone").eq().val(false).execute().get();}
            else {
            return mDlugiTable.where().field("Komu").eq().val(idZalogowany).and().
                    field("Splacone").eq().val(false).execute().get();
        }

    }


    public void updateDlugi (Dlugi item) throws ExecutionException, InterruptedException {
mDlugiTable.update(item).get();

    }
    public void aktulizujItem (final Dlugi tmp) {
        Thread nowywatek = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    updateDlugi(tmp);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
nowywatek.start();
    }
}
