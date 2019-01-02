package com.example.enji.uas_resep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateData extends Activity implements View.OnClickListener {

    private Button buttonSubmit;
    private EditText edNama;
    private EditText edBahan;
    private EditText edCara;

    private DBDataSource dataSource;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_data);
        buttonSubmit = (Button) findViewById(R.id.buttom_submit);
        buttonSubmit.setOnClickListener(this);
        edNama = (EditText) findViewById(R.id.nama_resep);
        edBahan = (EditText) findViewById(R.id.bahan);
        edCara = (EditText) findViewById(R.id.cara);
        dataSource = new DBDataSource(this);
        dataSource.open();
    }
    @Override
    public void onClick(View v) {
        String nama = null;
        String bahan = null;
        String cara = null;
        @SuppressWarnings("unused")
        Resep resep = null;
        if(edNama.getText()!=null && edBahan.getText()!=null && edCara.getText()!=null)
        {  nama = edNama.getText().toString();
            bahan = edBahan.getText().toString();
            cara = edCara.getText().toString();         }
        switch(v.getId())         {
            case R.id.buttom_submit:
                resep = dataSource.createResep(nama, bahan, cara);
                Toast.makeText(this, "input resep\n" +
                                "\nnama " + resep.getNama_resep() +
                                "\nbahan " + resep.getBahan() +
                                "\ncara " + resep.getCara_pembuatan(),
                        Toast.LENGTH_LONG).show();
                break;         }

        Intent masuk = new Intent( CreateData.this, Menu.class);
        startActivity(masuk);
    }
}
