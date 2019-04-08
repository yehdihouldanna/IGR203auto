package tpt.autocarplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.stream.Stream;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RadioActivity2 extends AppCompatActivity implements
        MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {
    //String stream="http://streaming.radio.funradio.fr/fun-1-48-192";

    private String TAG = getClass().getSimpleName();
    private MediaPlayer mp = null;

    private Button play;
    private Button pause;
    private Button stop;
    private String[] list_des_radios;
    private int i;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_radio2);

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
    }

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

}

