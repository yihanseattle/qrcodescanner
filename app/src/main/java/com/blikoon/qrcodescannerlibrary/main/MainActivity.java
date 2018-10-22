package com.blikoon.qrcodescannerlibrary.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.blikoon.qrcodescannerlibrary.R;
import com.blikoon.qrcodescannerlibrary.wifi.WifiActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final String LOGTAG = "QRCScanner-MainActivity";
    private CustomAdapterMainActivity mCustomAdapter;
    private ArrayList<DataModelMainActivity> mDataModelArrayList;

    @BindView(R.id.listview_activity_main)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: handle permission, but right now don't have to because Rokid Glass grants all permissions automatically
        initApp();
    }

    private void initApp() {
        initMainActivityListView();
    }

    private void initMainActivityListView() {
        mDataModelArrayList = new ArrayList<>();
        mDataModelArrayList.add(new DataModelMainActivity(R.drawable.flashlight_turn_on, "Wifi", "No Wifi Connected"));
        mDataModelArrayList.add(new DataModelMainActivity(R.drawable.flashlight_turn_on, "蓝牙", "No Bluetooth Connected"));
        mDataModelArrayList.add(new DataModelMainActivity(R.drawable.flashlight_turn_on, "亮度", ""));

        mCustomAdapter = new CustomAdapterMainActivity(mDataModelArrayList, this);
        mListView.setAdapter(mCustomAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataModelMainActivity dataModel = mDataModelArrayList.get(position);
                switch (position) {
                    case 0:
                        // wifi
                        startWifiActivity();
                        break;
                    case 1:
                        // bluetooth
                        Toast.makeText(MainActivity.this, "Bluetooth", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        // brightness
                        Toast.makeText(MainActivity.this, "Brightness", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void startWifiActivity() {
        Intent i = new Intent(MainActivity.this,WifiActivity.class);
        startActivity(i);
    }


}
