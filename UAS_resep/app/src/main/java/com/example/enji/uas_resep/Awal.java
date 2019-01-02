package com.example.enji.uas_resep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Awal extends Activity implements OnClickListener {

    private Button bAdmin;
    private Button bClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);

        bAdmin = (Button) findViewById(R.id.button_menu_admin);
        bAdmin.setOnClickListener(this);
        bClient = (Button) findViewById(R.id.button_menu_client);
        bClient.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.button_menu_admin :
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.button_menu_client :
                Intent i2 = new Intent(this, ViewDataClient.class);
                startActivity(i2);
                break;
        }
    }
}
