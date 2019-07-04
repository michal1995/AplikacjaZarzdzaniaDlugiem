package com.example.aplikacjazarzdzaniadlugiem;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class DodajDlugActivity extends Activity {


   private EditText editTextZaCo;
   private EditText editTextIle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_dlug);

        editTextIle = findViewById(R.id.editTextZaIle);
        editTextZaCo=findViewById(R.id.editTextZaCo);




    }
    public void onClickDodajDlug(View view) {
        DodajDlug dodajDlug = new DodajDlug(this,this);
        dodajDlug.execute(editTextZaCo.getText().toString(),editTextIle.getText().toString());
    }
    public void onClickClearText(View view)
    {
        if(view instanceof TextView)
        {
            TextView textView = (TextView)view;
            textView.setText("");
        }
    }
}
