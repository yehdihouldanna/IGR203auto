package tpt.autocarplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    static Boolean Bluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageButton bluetooth_button = findViewById(R.id.bluetooth);
        bluetooth_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bluetooth=true;
                startActivity(new Intent(MainActivity.this, BluetoothActivity.class));
            }
        });
        final ImageButton nobluetooth_button = findViewById(R.id.nobluetooth);
        nobluetooth_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bluetooth=false;
                startActivity(new Intent(MainActivity.this, MenuDisconnectActivity.class));
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}
