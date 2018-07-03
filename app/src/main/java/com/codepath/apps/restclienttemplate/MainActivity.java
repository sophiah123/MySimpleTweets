package com.codepath.apps.restclienttemplate;


import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
/* not this
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.miCompose:
                launchComposeView();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // ActivityOne.java
    public void launchComposeView() {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(TimelineActivity.class, ComposeActivity.class);
        startActivity(i); // brings up the second activity
    }
    */
}
