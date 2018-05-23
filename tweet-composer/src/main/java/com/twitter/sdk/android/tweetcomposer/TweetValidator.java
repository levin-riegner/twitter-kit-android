package com.twitter.sdk.android.tweetcomposer;

import com.twitter.Validator;

/**
 * Created by alex on 23/05/2018.
 */
public class TweetValidator extends Validator {

    public static final int MAX_TWEET_LENGTH = 280;

    @Override
    public boolean isValidTweet(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }

        for (char c : text.toCharArray()) {
            if (c == '\uFFFE' || c == '\uuFEFF' ||   // BOM
                    c == '\uFFFF' ||                     // Special
                    (c >= '\u202A' && c <= '\u202E')) {  // Direction change
                return false;
            }
        }

        return getTweetLength(text) <= MAX_TWEET_LENGTH;
    }
}
