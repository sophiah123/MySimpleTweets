package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;




public class ComposeActivity extends AppCompatActivity {

    EditText etCompose;
    TextView tvCharCount;
    TwitterClient client;
    Tweet tweet;

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
*/

    // ActivityTwo.java (subactivity) can access any extras passed in
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose2);
        /*String username = getIntent().getStringExtra("username");
        String inReplyTo = getIntent().getStringExtra("in_reply_to");
        int code = getIntent().getIntExtra("code", 0);
*/

        client = TwitterApp.getRestClient(this);
        etCompose = (EditText) findViewById(R.id.etCompose);
    }

    // ActivityNamePrompt.java -- launched for a result
    public void onSubmit(View v) {
        EditText etCompose = (EditText) findViewById(R.id.etCompose);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("name", etCompose.getText().toString());
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }

    public void composeTweet(View view) {

        client.sendTweet(etCompose.getText().toString(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    tweet = Tweet.fromJSON(response);
                    //Log.d("SendTweet", tweet.body);

                    // Prepare data intent
                    Intent data = new Intent();
                    // Pass relevant data back as a result
                    data.putExtra("tweet", Parcels.wrap(tweet));
                    //data.putExtra("code", 200); // ints work too
                    // Activity finished ok, return the data
                    setResult(RESULT_OK, data); // set result code and bundle data for response
                    finish(); // closes the activity, pass data to parent
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
