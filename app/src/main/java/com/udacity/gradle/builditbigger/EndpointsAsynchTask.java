package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.elearnna.www.jokesteller.jokesbackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Ahmed on 8/2/2017.
 */

public class EndpointsAsynchTask extends AsyncTask<Void, Void, String>{
    private static MyApi myApiService = null;
    private Context context;
    private OnReadingJokeComplete listener;

    public EndpointsAsynchTask(Context context, OnReadingJokeComplete listener) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // It is http://10.0.3.2:8080/_ah/api/ for GenyMotion
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }
        try {
            return myApiService.getAJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        listener.readJokeComplete(s);
    }
}
