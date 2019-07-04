package com.example.aplikacjazarzdzaniadlugiem;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.List;
import java.util.concurrent.ExecutionException;

    public class Rejestracja extends AsyncTask<String,Integer, String>{
     private MobileServiceTable<Uzytkownicy> mUzytkownicyTable= ServiceClient.getmInstance().getClient().getTable(Uzytkownicy.class);
     private List<Uzytkownicy> listaUzytkownikowTenSamLogin;
    Uzytkownicy tmpUzytkownik;
     ProgressDialog progressDialog;
     RejestracjaActivity activity;
    TextView textZajetyLogin;
    Context context;
    //Activity activityy;

     public Rejestracja(RejestracjaActivity activity,Context context)
     {
        this.activity=activity;
        this.context=context;
         progressDialog = new ProgressDialog(context);
         textZajetyLogin = activity.findViewById(R.id.textViewZajetyLogin);

     }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(this.context);
            progressDialog.setTitle("Rejestracja..");
            progressDialog.show();
        }
    @Override
    protected String doInBackground(String... strings) {
progressDialog.cancel();
        tmpUzytkownik= new Uzytkownicy();
        tmpUzytkownik.setmLogin(strings[0]);
        tmpUzytkownik.setmHaslo(strings[1]);
        try {
            listaUzytkownikowTenSamLogin=sprawdzDostepnosc(tmpUzytkownik);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(listaUzytkownikowTenSamLogin.isEmpty()) {
            try {
                dodajUzytkownika(tmpUzytkownik);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //textZajetyLogin.setVisibility(View.INVISIBLE);
            activity.finish();


        }
        else{
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textZajetyLogin.setVisibility(View.VISIBLE);
                }
            });}






        return null;
    }





    /**
     * Metoda dodająca użytkownika do tabeli Uzytkownicy w bazie danych
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws MobileServiceException
     */
    private void dodajUzytkownika(Uzytkownicy uzytkownik) throws ExecutionException, InterruptedException {
        mUzytkownicyTable.insert(uzytkownik).get();
    }
    private List<Uzytkownicy> sprawdzDostepnosc(Uzytkownicy uzytkownik) throws ExecutionException, InterruptedException {
        return mUzytkownicyTable.where().field("login").eq().val(uzytkownik.getmLogin()).execute().get();
    }
}
