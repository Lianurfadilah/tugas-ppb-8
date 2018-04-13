package com.lianurfadilah46.tgsstudykasus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by lianurfadilah46 on 4/11/2018.
 */

public class Transportasi extends ListActivity {
        String[] transportasi = {
                "Pesawat Terbang",
                "Taksi",
                "Bus",
                "Mobil Rental Pribadi",
                "Kereta Api"
        };
        @Override
        public void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_transportasi);
            ListView listView = getListView();
            listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            listView.setTextFilterEnabled(true);
            setListAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_checked, transportasi));

        }
        public void onListItemClick(
                ListView parent, View view, int position, long id)
        {

        }
        public void onClick (View view){
            ListView listView = getListView();
            String menu = "";
            for (int i = 0; i < listView.getCount() ; i++){
                if (listView.isItemChecked(i)) {
                    menu += listView.getItemAtPosition(i)+"\n";
                }
            }
            Intent intent = new Intent(this, AsalTujuan.class);
            intent.putExtra("Transportasi", menu);
            startActivity(intent);
        }
}
