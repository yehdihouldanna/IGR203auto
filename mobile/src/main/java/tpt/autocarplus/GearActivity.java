package tpt.autocarplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import static tpt.autocarplus.MainActivity.Bluetooth;

//INUTILISÉ

public class GearActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gearactivity);

        final ImageButton return_button = findViewById(R.id.returnmenu);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Bluetooth){
                    startActivity(new Intent(GearActivity.this, MenuBluetooth.class));}
                else{
                    startActivity(new Intent(GearActivity.this, MenuDisconnectActivity.class));}
            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}
