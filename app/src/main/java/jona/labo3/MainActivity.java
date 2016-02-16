package jona.labo3;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;


import java.util.Locale;

import static jona.labo3.R.id.eT;

public class MainActivity extends AppCompatActivity {

    private Integer cont;
    private EditText et;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        et=(EditText)findViewById(eT);
        cont=Integer.parseInt(et.getText().toString());
        cont=cont+1;
        outState.putInt("data", cont);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        et=(EditText)findViewById(eT);
        cont = savedInstanceState.getInt("data");
        et.setText(cont.toString());
    }

    public void castellano(View w){
        Locale cas= new Locale("es");
        Locale.setDefault(cas);
        Configuration config= new Configuration();
        config.locale=cas;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        finish();
        startActivity(getIntent());
    }

    public void ingles(View w){
        Locale ing= new Locale("en");
        Locale.setDefault(ing);
        Configuration config= new Configuration();
        config.locale=ing;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        finish();
        startActivity(getIntent());
    }
}
