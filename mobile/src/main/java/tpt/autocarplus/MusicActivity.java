package tpt.autocarplus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.widget.ArrayAdapter;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener{

    // pour changer l'icon du bouton play quand elle est pressée

    Button mPlayButton;

    boolean isPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicactivity);

        final ImageButton return_button = findViewById(R.id.returnmenu);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MusicActivity.this, MenuBluetooth.class));
            }
        });


//        mPlayButton = (Button) findViewById(R.id.play);
//        mPlayButton.setOnClickListener(mTogglePlayButton);
    }

//    View.OnClickListener mTogglePlayButton = new View.OnClickListener(){
//
//        @Override
//        public void onClick(View v){
//            // change your button background
//            isPlay = !isPlay; // reverse
//            if(isPlay){
//                v.setBackgroundResource(android.R.drawable.ic_media_play);
//            }else{
//                //v.setImageResource(android.R.drawable.ic_media_pause);
//                v.setBackgroundResource(android.R.drawable.ic_media_pause);
//            }
//
//
//        }
//
//    };

    @Override
    public void onClick(View view) {

    }




}