package com.example.aplikacjazarzdzaniadlugiem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;


public class LoginActivity extends AppCompatActivity {

    //Debug Text View
    private TextView debug;
    private EditText loginEditText;
    private EditText hasloEditText;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        debug = findViewById(R.id.debugTextView);
        loginEditText = findViewById(R.id.loginEditText);
        hasloEditText = findViewById(R.id.hasloEditText);

        try {
            ServiceClient.Initialize(this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public void onClickZaloguj(View v)  {
        debug.setVisibility(View.INVISIBLE);

        Logowanie myTask = new Logowanie(this,this.debug,this);

       myTask.execute(loginEditText.getText().toString(), hasloEditText.getText().toString());


    }

    public void onClickRejestracja(View v)
    {
        debug.setVisibility(View.INVISIBLE);
        intent = new Intent(this,RejestracjaActivity.class);
        startActivity(intent);
    }

    public void onClickZmienJezyk(View v){
        Button zmienJezyk = findViewById(R.id.buttonZmianaJezyka);
        zmienJezyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokazZmianeJezyk();
            }
        });


    }

   public void pokazZmianeJezyk(){
       final String[] tablica = { "english" , "sadas"};
       final AlertDialog.Builder mBuilder = new AlertDialog.Builder(LoginActivity.this);
       mBuilder.setTitle("wybierz jezyk");
       mBuilder.setSingleChoiceItems(tablica, -1, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int a) {

               if(a== 0){

                   setLocale("eng");
                   recreate();

               }
               if(a== 1){

                   setLocale("pl");
                   recreate();

               }

           //AlertDialog mDialog = new mBuilder.create();
             //  mDialog.show();


           }
       });

   }

    private void setLocale(String pl) {



    }


}
