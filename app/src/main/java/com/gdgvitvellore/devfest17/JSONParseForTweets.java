package com.gdgvitvellore.devfest17;

        import android.util.Log;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by tanmay on 3/6/17.
 */

public class JSONParseForTweets {
    public static String[] tweetText;
    public static String[] tweetImageUrl;
    public static String[] time;
    public static String[] userName;
    List<TweetModel> tweetModelList;
    private JSONArray tweetJSONArray = null;
    private String json;

    public JSONParseForTweets(String json){
        this.json=json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;

        try {
            tweetJSONArray=new JSONArray(json);
            //This code basically converts the json string into jsonArray.
            //Cool isn't it? Sad, there are enough emoji for desktop keyboard :/

            Log.v("JSONParse",tweetJSONArray.toString());

            tweetText=new String[tweetJSONArray.length()];
            tweetImageUrl=new String[tweetJSONArray.length()];
            time=new String[tweetJSONArray.length()];
            userName = new String[tweetJSONArray.length()];

            tweetModelList=new ArrayList<TweetModel>();

            for (int i=0;i< tweetJSONArray.length();i++){
                TweetModel TweetModelObject=new TweetModel();
                JSONObject object=tweetJSONArray.getJSONObject(i);
                tweetText[i]=object.getString("text");
                tweetImageUrl[i]= object.getJSONObject("user").getString("profile_image_url");
                time[i]=object.getString("created_at");
                userName[i] = object.getString("");
                TweetModelObject.setTime(time[i]);
                TweetModelObject.setTweetImageUrl(tweetImageUrl[i]);
                TweetModelObject.setTweetText(tweetText[i]);
                TweetModelObject.setUserName(userName[i]);
                Log.v("tweetText",tweetText[i]);
                Log.v("tweetImage",tweetImageUrl[i]);
                Log.v("tweetTime",time[i]);
                tweetModelList.add(TweetModelObject);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    List<TweetModel> getTweetList()
    {
        return tweetModelList;
    }
}