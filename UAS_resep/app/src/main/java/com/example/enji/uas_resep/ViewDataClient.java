package com.example.enji.uas_resep;

import java.util.ArrayList;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ViewDataClient extends ListActivity implements OnItemLongClickListener {

    private DBDataSource dataSource;
    private ArrayList<Resep> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data_client);
        dataSource = new DBDataSource(this);

        dataSource.open();

        values = dataSource.getAllResep();

        ArrayAdapter<Resep> adapter = new ArrayAdapter<Resep>(this,
                android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);

        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> adapter, View v, int pos,
                                   final long id) {

        /*
//tampilkan alert dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_view);
        dialog.setTitle("Pilih Aksi");
        dialog.show();
        final Resep b = (Resep) getListAdapter().getItem(pos);
        editButton = (Button) dialog.findViewById(R.id.button_edit_data);
        delButton = (Button) dialog.findViewById(R.id.button_delete_data);
//apabila tombol edit diklik
        editButton.setOnClickListener(
                new OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
// TODO Auto-generated method stub
                        switchToEdit(b.getId());
                        dialog.dismiss();
                    }
                }
        );
//apabila tombol delete di klik
        delButton.setOnClickListener(
                new OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
// Delete Sekolah
                        dataSource.deleteResep(b.getId());
                        dialog.dismiss();
                        finish();
                        startActivity(getIntent());
                    }
                }
        );
        */
        return true;
    }

    public void switchToEdit(long id)
    {
        Resep b = dataSource.getResep(id);
        Intent i = new Intent(this, EditData.class);
        Bundle bun = new Bundle();
        bun.putLong("id", b.getId());
        bun.putString("nama", b.getNama_resep());
        bun.putString("bahan", b.getBahan());
        bun.putString("cara_pembuatan", b.getCara_pembuatan());
        i.putExtras(bun);
        finale();
        startActivity(i);
    }
    public void finale()
    {
        ViewDataClient.this.finish();
        dataSource.close();
    }
    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }
    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }
}
