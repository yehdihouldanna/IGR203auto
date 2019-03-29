package tpt.autocarplus;

/**
 * Created by Martin Paul-Ernest on 28/03/2019.
 */

public class Tweet {
    private int color;
    private String pseudo;
    private String text;

    public Tweet(int color, String pseudo, String text) {
        this.color = color;
        this.pseudo = pseudo;
        this.text = text;
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
}