package tpt.autocarplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static android.widget.LinearLayout.VERTICAL;
import static tpt.autocarplus.RadioActivity3.favoriteListMap;

public class RadioFavoriteList extends AppCompatActivity implements View.OnClickListener{

private int i=-1;
private Map<Button,Integer> buttonMap=new HashMap<>();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.favoritelist);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        final LinearLayout linearLayout = findViewById(R.id.ll);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //final Map<Integer, RadioActivity3.StationButton>favoriteListMapCopy = favoriteListMap;
        int j=0;
        for (final Map.Entry<Integer, RadioActivity3.StationButton> entry : favoriteListMap.entrySet()) {
            RadioActivity3.StationButton stationButton = entry.getValue();
            final Button newButton = new Button(this);
            newButton.setText(stationButton.getRadioStation());
            newButton.setId(stationButton.getId());
            buttonMap.put(newButton,j);
            newButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    i=buttonMap.get(newButton);
                }
            });
            linearLayout.addView(newButton,j,lp);
            j++;
        }


        final ImageButton return_button = findViewById(R.id.returnmenu);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(RadioFavoriteList.this, RadioActivity3.class));
            }
        });

        final Button remove_button = findViewById(R.id.removeFromList);
        remove_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (i != -1) {
                    System.out.println(i);
                    favoriteListMap.remove(i);
                    linearLayout.removeViewAt(i);
                    try {
                        FileOutputStream fos = getApplicationContext().openFileOutput("favoriteList", Context.MODE_PRIVATE);
                        ObjectOutputStream os = new ObjectOutputStream(fos);

                        os.writeObject(favoriteListMap);
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





    }

    @Override
    public void onClick(View view) {

    }


}
