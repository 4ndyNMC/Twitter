package com.codepath.apps.restclienttemplate.models;

import androidx.room.Embedded;

import java.util.ArrayList;
import java.util.List;

public class TweetWithUser {

    @Embedded
    User user;

    @Embedded(prefix = "tweet_")
    Tweet tweet;

    public static List<Tweet> getTweetList(List<TweetWithUser> tweetWithUsers) {
        List<Tweet> tweets = new ArrayList<>();
        for (TweetWithUser tweetWithUser : tweetWithUsers) {
            Tweet tweet = new Tweet();
            tweet.user = tweetWithUser.user;
            tweet.body = tweetWithUser.tweet.body;
            tweet.attachmentUrl = tweetWithUser.tweet.attachmentUrl;
            tweet.createdAt = tweetWithUser.tweet.createdAt;
            tweet.date = tweetWithUser.tweet.date;
            tweets.add(tweet);
        }
        return tweets;
    }
}
