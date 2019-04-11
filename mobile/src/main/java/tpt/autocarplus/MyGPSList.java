package tpt.autocarplus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import static tpt.autocarplus.GpsActivity1.addressListVector;
import static tpt.autocarplus.GpsActivity1.addressToSend;

public class MyGPSList extends AppCompatActivity implements View.OnClickListener{


    private int i=-1;
    private HashMap<Button, Integer> buttonMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gpslist);


        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        final LinearLayout linearLayout = findViewById(R.id.ll);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //final Map<Integer, RadioActivity3.StationButton>favoriteListMapCopy = favoriteListMap;
        int j=0;
        Iterator<String> itr = addressListVector.iterator();
        while (itr.hasNext()) {
            final String address = itr.next();
            final Button newButton = new Button(this);
            newButton.setText(address);
            //newButton.setId(stationButton.getId());
            buttonMap.put(newButton,j);
            newButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    i=buttonMap.get(newButton);
                    addressToSend=address;
                }
            });
            linearLayout.addView(newButton,j,lp);
            j++;
        }


        final ImageButton return_button = findViewById(R.id.returnmenu);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyGPSList.this, GpsActivity.class));
            }
        });

        final Button remove_button = findViewById(R.id.removeFromList);
        remove_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (i != -1) {
                    System.out.println(i);
                    addressListVector.remove(i);
                    linearLayout.removeViewAt(i);
                    try {
                        FileOutputStream fos = getApplicationContext().openFileOutput("favoriteList", Context.MODE_PRIVATE);
                        ObjectOutputStream os = new ObjectOutputStream(fos);

                        os.writeObject(addressListVector);
                        os.close();
                        fos.close();


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        final Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyGPSList.this, GpsActivity2.class));
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
