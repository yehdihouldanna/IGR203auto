package tpt.autocarplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import static tpt.autocarplus.GpsActivity1.addressToSend;
import static tpt.autocarplus.GpsActivity1.whileItinerary;
import static tpt.autocarplus.MainActivity.Bluetooth;

public class GpsActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps2);

        TextView textView = findViewById(R.id.text);
        textView.setText("Destination : " + addressToSend);

        final Button newItineraryButton = findViewById(R.id.newItinerary);
        newItineraryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(GpsActivity2.this, GpsActivity.class));
            }
        });

        final Button myListButton = findViewById(R.id.myList);
        myListButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(GpsActivity2.this, MyGPSList.class));
            }
        });

        final Button returnMainMenuButton= findViewById(R.id.returnmainmenu);
        returnMainMenuButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                whileItinerary=false;
                if (Bluetooth) {
                    startActivity(new Intent(GpsActivity2.this, MenuBluetooth.class));
                }
                else {
                    startActivity(new Intent(GpsActivity2.this, MenuDisconnectActivity.class));
                }
            }
        });
    }
}
