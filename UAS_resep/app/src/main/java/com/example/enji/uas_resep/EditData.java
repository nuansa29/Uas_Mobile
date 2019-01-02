package com.example.enji.uas_resep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditData extends Activity implements View.OnClickListener {

    private DBDataSource dataSource;
    private long id;
    private String cara;
    private String bahan;
    private String nama;
    private EditText edNama;
    private EditText edCara;
    private EditText edBahan;
    private TextView txId;
    private Button btnSave;
    private Button btnCancel;
    private Resep resep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        edNama = (EditText) findViewById(R.id.editText_nama);
        edBahan = (EditText) findViewById(R.id.editText_bahan);
        edCara = (EditText) findViewById(R.id.editText_cara);
        txId = (TextView) findViewById(R.id.text_id_resep);

        dataSource = new DBDataSource(this);
        dataSource.open();

        Bundle bun = this.getIntent().getExtras();
        id = bun.getLong("id");
        cara = bun.getString("cara");
        bahan = bun.getString("bahan");
        nama = bun.getString("nama");

        txId.append(String.valueOf(id));
        edNama.setText(nama);
        edCara.setText(cara);
        edBahan.setText(bahan);

        btnSave = (Button) findViewById(R.id.button_save_update);
        btnSave.setOnClickListener(this);
        btnCancel = (Button) findViewById(R.id.button_cancel_update);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        switch(v.getId())
        {

            case R.id.button_save_update :
                resep = new Resep();
                resep.setCara_pembuatan(edCara.getText().toString());
                resep.setNama_resep(edNama.getText().toString());
                resep.setBahan(edBahan.getText().toString());
                resep.setId(id);
                dataSource.updateResep(resep);
                Intent i = new Intent(this, ViewData.class);
                startActivity(i);
                EditData.this.finish();
                dataSource.close();
                break;

            case R.id.button_cancel_update :
                finish();
                dataSource.close();
                break;
        }
    }
}
