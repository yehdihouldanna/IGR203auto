package tpt.autocarplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuBluetooth extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menubluetooth);

        final ImageButton map_button = findViewById(R.id.map);
        map_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuBluetooth.this, GpsActivity.class));
            }
        });

        final ImageButton music_button = findViewById(R.id.music);
        music_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuBluetooth.this, MusicActivity.class));
            }
        });
        final ImageButton contact_button = findViewById(R.id.phone);
        contact_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuBluetooth.this, ContactActivity.class));
            }
        });
        final ImageButton bluetooth_button = findViewById(R.id.bluetooth);
        bluetooth_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuBluetooth.this, BluetoothActivity.class));
            }
        });
        final ImageButton gear_button = findViewById(R.id.gear);
        gear_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuBluetooth.this, GearActivity.class));
            }
        });
        final ImageButton car_button = findViewById(R.id.car);
        car_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuBluetooth.this, CarActivity.class));
            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}
