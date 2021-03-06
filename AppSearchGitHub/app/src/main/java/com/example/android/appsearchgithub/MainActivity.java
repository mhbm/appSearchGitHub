package com.example.android.appsearchgithub;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.appsearchgithub.adapter.RepoAdapter;
import com.example.android.appsearchgithub.data.RepoModel;
import com.example.android.appsearchgithub.utilities.NetworkUtils;
import com.example.android.appsearchgithub.utilities.OpenGithubJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName().toString();

    private RecyclerView mRecyclerView;
    private TextView mErrorMessageDisplay;
    private ProgressBar mLoadingIndicator;

    private RepoAdapter mRepoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_listRepo);
        mErrorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        mRepoAdapter = new RepoAdapter((RepoAdapter.RepoAdapterOnClickHandler) this);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        loadRepoGithub();
    }

    private void loadRepoGithub() {
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
        new FetchRepoTask().execute();
    }

    private class FetchRepoTask extends AsyncTask<String, Void, RepoModel[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected RepoModel[] doInBackground(String... strings) {

            try {
                URL githubRequestURL = NetworkUtils.buildUrl();

                String jsonGithubResponse = NetworkUtils.getResponseFromHttpUrl(githubRequestURL);

                RepoModel[] repoModelData = OpenGithubJsonUtils.getRepoFromJson(jsonGithubResponse);

                return repoModelData;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(RepoModel[] repoModelData) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);

            if (repoModelData != null) {
                mErrorMessageDisplay.setVisibility(View.INVISIBLE);
                mRecyclerView.setVisibility(View.VISIBLE);
            }

        }
    }
}
