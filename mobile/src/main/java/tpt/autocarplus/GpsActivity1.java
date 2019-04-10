package tpt.autocarplus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

import static tpt.autocarplus.MainActivity.Bluetooth;

public class GpsActivity1 extends AppCompatActivity implements View.OnClickListener{

    public static String finalAdress;
    public static Vector<String> addressListVector = new Vector<>();
    public static String addressToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpsactivity1);


        final ImageButton return_button = findViewById(R.id.returnmenu);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(GpsActivity1.this, GpsActivity.class));
            }
        });

        final Button myListButton = findViewById(R.id.myList);
        myListButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(GpsActivity1.this, MyGPSList.class));
            }
        });

        final Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText fillText = findViewById(R.id.fillText);
                finalAdress = fillText.getText().toString();
                addressToSend = finalAdress + " " + GpsActivity.cityLocation;
                startActivity(new Intent(GpsActivity1.this, GpsActivity2.class));
            }
        });

        final Button addButton = findViewById(R.id.addToList);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //on vérifie si le fichier existe
                File addressList = getApplicationContext().getFileStreamPath("addressList");
                if (addressList.exists() && addressList != null) {
                    try {
                        FileInputStream fis = getApplicationContext().openFileInput("addressList");
                        ObjectInputStream is = new ObjectInputStream(fis);
                        addressListVector = (Vector<String>) is.readObject();
                        is.close();
                        fis.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    FileOutputStream fos = getApplicationContext().openFileOutput("addressList", Context.MODE_PRIVATE);
                    ObjectOutputStream os = new ObjectOutputStream(fos);


                    addressListVector.add(finalAdress + " " + GpsActivity.cityLocation);
                    os.writeObject(addressListVector);
                    os.close();
                    fos.close();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
