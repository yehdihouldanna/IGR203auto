package tpt.autocarplus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactactivity);
        mListView = (ListView) findViewById(R.id.listView);

        List<Tweet> tweets = genererTweets();

        TweetAdapter adapter = new TweetAdapter(ContactActivity.this, tweets);
        mListView.setAdapter(adapter);

        final ImageButton validate_button = findViewById(R.id.validate);
        validate_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ContactActivity.this, MainActivity.class));
            }
        });
        final ImageButton return_button = findViewById(R.id.returnmenu);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ContactActivity.this, MainActivity.class));
            }
        });

    }

    private List<Tweet> genererTweets(){
        List<Tweet> tweets = new ArrayList<Tweet>();
        tweets.add(new Tweet(Color.BLACK, "Florent", "Samsung G14"));
        tweets.add(new Tweet(Color.BLUE, "Kevin", "Iphone triple X"));
        tweets.add(new Tweet(Color.GREEN, "Logan", "Nokia c4"));
        return tweets;
    }

    @Override
    public void onClick(View view) {

    }
}