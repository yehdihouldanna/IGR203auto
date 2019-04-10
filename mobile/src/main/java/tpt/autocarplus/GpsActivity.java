package tpt.autocarplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import static tpt.autocarplus.MainActivity.Bluetooth;

public class GpsActivity extends AppCompatActivity implements View.OnClickListener{

    public static String cityLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpsactivity);

        final ImageButton return_button = findViewById(R.id.returnmenu);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Bluetooth){
                    startActivity(new Intent(GpsActivity.this, MenuBluetooth.class));}
                else{
                    startActivity(new Intent(GpsActivity.this, MenuDisconnectActivity.class));}
            }
        });


        final Button myListButton = findViewById(R.id.myList);
        myListButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(GpsActivity.this, MyGPSList.class));
            }
        });

        final Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText fillText = findViewById(R.id.fillText);
                cityLocation = fillText.getText().toString();
                startActivity(new Intent(GpsActivity.this, GpsActivity1.class));
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}
