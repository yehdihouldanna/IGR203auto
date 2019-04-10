package tpt.autocarplus;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Martin Paul-Ernest on 28/03/2019.
 */

public class TweetAdapter extends ArrayAdapter<Tweet> {

    //tweets est la liste des models à afficher
    public TweetAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);

    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {


        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.phonexml,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }


        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Tweet tweet = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.pseudo.setText(tweet.getpseudoTweet());
        viewHolder.text.setText(tweet.gettextTweet());
        viewHolder.phoneNumber.setText(tweet.getPhoneNumber());
        final String phoneNumber = tweet.getPhoneNumber();
        final Button button = convertView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ContactActivity.numberToCall=phoneNumber;

            }
        });


        return convertView;
    }

    private class TweetViewHolder{
        public TextView pseudo;
        public TextView text;
        public TextView phoneNumber;
        public ImageView avatar;
        public ImageButton button;
    }
}