package com.example.aplikacjazarzdzaniadlugiem;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DodajDlug  extends AsyncTask<String,Void,Void>{

    /**
     * Referencja do tabeli dlugi
     */
    private MobileServiceTable<Dlugi> mDlugTable;

    Activity activity;
    Context context;
    ProgressDialog progressDialog;

    public DodajDlug( Context context,Activity activity)
    {
        this.activity = activity;
        this.context = context;
        mDlugTable = ServiceClient.getmInstance().getClient().getTable(Dlugi.class);
    }
    /**
     * Wywołanie asynchronicznego zadania
     * do metody doInBackground
     * @param strings przekazujemy Stringi z editText
     * w kolejnosci zaCo,ile
     */
    @Override
    protected Void doInBackground(String... strings) {

       for (Uzytkownicy item : ZalogowanyUzytkownik.getInstance().getListaDodanychUzytkownikow()) {

           Dlugi dlugiTMP = new Dlugi();
            dlugiTMP.setmPotwierdzone(false);
            dlugiTMP.setmSplacone(false);
            dlugiTMP.setmZaCo(strings[0]);
            dlugiTMP.setmIle(Float.parseFloat(strings[1]));
            dlugiTMP.setmKomu(ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmId());
            dlugiTMP.setmKto(item.getmId());
            dlugiTMP.setmKtoLogin(item.getmLogin());
            dlugiTMP.setmKomuLogin(ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmLogin());

            try {
                dodajDlug(dlugiTMP);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (MobileServiceException e) {
                e.printStackTrace();
            }
       }
        return null;
    }

    @Override
    protected void onPreExecute() {
        progressDialog =new ProgressDialog(context);
        progressDialog.setTitle("Dodawanie długu. Proszę czekać");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        ZalogowanyUzytkownik.getInstance().zerujElemntyListy();
        TextView textView = activity.findViewById(R.id.textViewDebugDlug);
        textView.setText("Dodano dług");
        progressDialog.cancel();
    }


    private void dodajDlug(Dlugi tmp) throws ExecutionException, InterruptedException, MobileServiceException {
        mDlugTable.insert(tmp).get();
    }
}
