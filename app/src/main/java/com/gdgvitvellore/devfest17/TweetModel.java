package com.gdgvitvellore.devfest17;

/**
 * Created by Abhinav on 28/10/17.
 */

public class TweetModel {
    private String time;
    private String tweetImageUrl;
    private String tweetText;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTweetImageUrl() {
        return tweetImageUrl;
    }

    public void setTweetImageUrl(String tweetImageUrl) {
        this.tweetImageUrl = tweetImageUrl;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }
}
