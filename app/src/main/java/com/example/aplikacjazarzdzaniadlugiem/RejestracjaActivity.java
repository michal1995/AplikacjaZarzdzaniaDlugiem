package com.example.aplikacjazarzdzaniadlugiem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class RejestracjaActivity extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextHaslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        editTextLogin = findViewById(R.id.editLoginText1);
        editTextHaslo = findViewById(R.id.editHasloText2);
    }

    public void onClickRejestracja(View v)
    {

        Rejestracja rejestracja = new Rejestracja(this,this);
        rejestracja.execute(editTextLogin.getText().toString(),editTextHaslo.getText().toString());
    }


}
