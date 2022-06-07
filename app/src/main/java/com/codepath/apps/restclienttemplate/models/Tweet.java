package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {

    public static final String TAG = "Tweet";
    public String body;
    public String createdAt;
    public String attachmentUrl;
    public User user;

    // empty constructor needed by Parceler library
    public  Tweet() {}

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        if (jsonObject.getJSONObject("entities").has("media")) {
            tweet.attachmentUrl = jsonObject.getJSONObject("entities")
                    .getJSONArray("media").getJSONObject(0).getString("media_url");
            Log.i(TAG, "MEDIA URL: " + tweet.attachmentUrl);
        }
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<Tweet>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return tweets;
    }
}