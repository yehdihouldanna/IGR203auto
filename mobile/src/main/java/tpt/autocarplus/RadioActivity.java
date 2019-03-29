package tpt.autocarplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class RadioActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radioactivity);

        final ImageButton music_button = findViewById(R.id.returnmenu);
        music_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(RadioActivity.this, MenuDisconnectActivity.class));
            }
        });
    }
    @Override
    public void onClick(View view) {

    }
}