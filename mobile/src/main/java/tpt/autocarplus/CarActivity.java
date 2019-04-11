package tpt.autocarplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import static tpt.autocarplus.MainActivity.Bluetooth;


public class CarActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caractivity);
//
//        final ImageButton return_button = findViewById(R.id.returnmenu);
//        return_button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (Bluetooth){
//                    startActivity(new Intent(CarActivity.this, MenuBluetooth.class));}
//                else{
//                    startActivity(new Intent(CarActivity.this, MenuDisconnectActivity.class));}
//            }
//        });

    }


    @Override
    public void onClick(View view) {

    }
}
