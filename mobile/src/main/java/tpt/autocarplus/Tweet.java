package tpt.autocarplus;

import android.graphics.Color;

/**
 * Created by Martin Paul-Ernest on 28/03/2019.
 */

public class Tweet {
    private int color;
    private String pseudo;
    private String text;
    private String phoneNumber;

    public Tweet(int color, String pseudo, String text, String phoneNumber) {
        this.color = color;
        this.pseudo = pseudo;
        this.text = text;
        this.phoneNumber = phoneNumber;
    }

    public Tweet(int color, String pseudo, String phoneNumber) {
        this.color = color;
        this.pseudo = pseudo;
        this.phoneNumber = phoneNumber;
        this.text = "   ";
    }

    public int getColorTweet(){
        return (this.color);
    }

    public String getpseudoTweet(){
        return (this.pseudo);
    }
    public String gettextTweet(){
        return (this.text);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}