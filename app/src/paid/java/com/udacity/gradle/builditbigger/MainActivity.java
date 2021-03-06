package com.udacity.gradle.builditbigger;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.elearnna.www.androidjokeslib.JokeActivity;


public class MainActivity extends AppCompatActivity implements OnReadingJokeComplete {
    private Intent intent;
    private String currentJoke;
    private ProgressBar donutProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutProgress = (ProgressBar) findViewById(R.id.donut_progress);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        donutProgress.setVisibility(View.VISIBLE);
        EndpointsAsynchTask asynchTask = new EndpointsAsynchTask(getApplicationContext(), this);
        asynchTask.execute();
    }


    @Override
    public void readJokeComplete(String joke) {
        currentJoke = joke;
        publishJoke();
        donutProgress.setVisibility(View.GONE);
    }

    private void publishJoke() {
        intent = new Intent(getApplicationContext(), JokeActivity.class);
        intent.putExtra("joke", currentJoke);
        startActivity(intent);
    }
}
