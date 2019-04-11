package tpt.autocarplus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.widget.Button;
import android.view.View;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import static tpt.autocarplus.MainActivity.Bluetooth;

public class RadioActivity3 extends AppCompatActivity implements View.OnClickListener, Serializable
      /*  MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener */{
    //String stream="http://streaming.radio.funradio.fr/fun-1-48-192";

    /* private String TAG = getClass().getSimpleName();
     private MediaPlayer mp = null;

     private Button play;
     private Button pause;
     private Button stop;
     private String[] list_des_radios;*/
    private int i=-1;


    public class StationButton implements Serializable {
        private int id;
        private String radioStation;
        private int height;
        private int width;

        public StationButton(final int id) {
            this.id=id;
            Button button=null;
            //code pas optimal...
            switch(id) {
                case 0:
                    button = (Button) findViewById(R.id.button0);
                    radioStation="RTL";
                    break;
                case 1:
                    button = (Button) findViewById(R.id.button1);
                    radioStation="RMC";
                    break;
                case 2:
                    button = (Button) findViewById(R.id.button2);
                    radioStation="EUROPE 1";
                    break;
                case 3:
                    button = (Button) findViewById(R.id.button3);
                    radioStation="RFM";
                    break;
                case 4:
                    button = (Button) findViewById(R.id.button4);
                    radioStation="FIP";
                    break;
                case 5:
                    button = (Button) findViewById(R.id.button5);
                    radioStation="ABC Lounge";
                    break;
                case 6:
                    button = (Button) findViewById(R.id.button6);
                    radioStation="LA RADIO SYMPA";
                    break;
                case 7:
                    button = (Button) findViewById(R.id.button7);
                    radioStation="RADIO CLASSIQUE";
                    break;
                case 8:
                    button = (Button) findViewById(R.id.button8);
                    radioStation="LATINA";
                    break;
            }
            height=button.getHeight();
            width=button.getWidth();
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    i=id;
                }
            });

        }


        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getRadioStation() {
            return radioStation;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
    }

    //variable de classe
    public static HashMap<Integer, StationButton> favoriteListMap = new HashMap<>();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_radio3);


        final StationButton buttonList[]= new StationButton[9];
        for (int i = 0; i < 9; i++) {
            buttonList[i]=new StationButton(i);
        }



        final ImageButton return_button = findViewById(R.id.returnmenu);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Bluetooth){
                    startActivity(new Intent(RadioActivity3.this, MenuBluetooth.class));
                }
                else {
                    startActivity(new Intent(RadioActivity3.this, MenuDisconnectActivity.class));
                }
            }
        });

        final Button myList_button = (Button) findViewById(R.id.myList);
        myList_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(RadioActivity3.this, RadioFavoriteList.class));
            }
        });

        final Button add_button = (Button) findViewById(R.id.addToList);
        add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //on vérifie si le fichier existe
                if (i != -1) {
                    File favoriteList = getApplicationContext().getFileStreamPath("favoriteList");
                    if (favoriteList.exists() && favoriteList != null) {
                        try {
                            FileInputStream fis = getApplicationContext().openFileInput("favoriteList");
                            ObjectInputStream is = new ObjectInputStream(fis);
                            favoriteListMap = (HashMap<Integer, StationButton>) is.readObject();
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
                        FileOutputStream fos = getApplicationContext().openFileOutput("favoriteList", Context.MODE_PRIVATE);
                        ObjectOutputStream os = new ObjectOutputStream(fos);

                        favoriteListMap.put(i, buttonList[i]);
                        os.writeObject(favoriteListMap);
                        os.close();
                        fos.close();
                        i = -1;


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
/*
        list_des_radios= new String[4];
        i=0;

        list_des_radios[0]="http://streaming.radio.funradio.fr/fun-tls-44-128";  //funradio
        list_des_radios[1]="http://bbcmedia.ic.llnwd.net/stream/bbcmedia_radio1_mf_p?s=1554392473&e=1554406873&h=4a2fe03ac31f2731c953fad211dfb860";    //bbcradio1
        list_des_radios[2]="http://ais.rtl.fr:80/rtl-1-44-128";       //rtl radio france
        list_des_radios[3]="http://bbcmedia.ic.llnwd.net/stream/bbcmedia_radio5live_mf_q";  //livebbc radio5

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                play();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stop();
            }
        });
        */
    }


    @Override
    public void onClick(View view) {

    }

/*
    private void play() {
        Uri myUri = Uri.parse(list_des_radios[2]);
        try {
            if (mp == null) {
                this.mp = new MediaPlayer();
            } else {
                mp.stop();
                mp.reset();
            }
            mp.setDataSource(this, myUri); // Go to Initialized state
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setOnPreparedListener(this);
            mp.setOnBufferingUpdateListener(this);

            mp.setOnErrorListener(this);
            mp.prepareAsync();

            Log.d(TAG, "LoadClip Done");
        } catch (Throwable t) {
            Log.d(TAG, t.toString());
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.d(TAG, "Stream is prepared");
        mp.start();
    }

    private void pause() {
        mp.pause();
    }

    private void stop() {
        mp.stop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stop();

    }

    public void onCompletion(MediaPlayer mp) {
        stop();
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        StringBuilder sb = new StringBuilder();
        sb.append("Media Player Error: ");
        switch (what) {
            case MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:
                sb.append("Not Valid for Progressive Playback");
                break;
            case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                sb.append("Server Died");
                break;
            case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                sb.append("Unknown");
                break;
            default:
                sb.append(" Non standard (");
                sb.append(what);
                sb.append(")");
        }
        sb.append(" (" + what + ") ");
        sb.append(extra);
        Log.e(TAG, sb.toString());
        return true;
    }

    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        Log.d(TAG, "PlayerService onBufferingUpdate : " + percent + "%");
    }
*/
}

