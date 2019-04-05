package tpt.autocarplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MenuDisconnectActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menudisconnectbluetooth);

        final ImageButton map_button = findViewById(R.id.map);
        map_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuDisconnectActivity.this, GpsActivity.class));
            }
        });
        final ImageButton gear_button = findViewById(R.id.gear);
        gear_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuDisconnectActivity.this, GearActivity.class));
            }
        });
        final ImageButton car_button = findViewById(R.id.car);
        car_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuDisconnectActivity.this, CarActivity.class));
            }
        });
        final ImageButton radio_button = findViewById(R.id.radio);
        radio_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuDisconnectActivity.this, RadioActivity2.class));
            }
        });
    }
    @Override
    public void onClick(View view) {
    }
}
