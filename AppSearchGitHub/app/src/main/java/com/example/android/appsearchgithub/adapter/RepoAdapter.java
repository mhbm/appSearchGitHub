package com.example.android.appsearchgithub.adapter;

import com.example.android.appsearchgithub.data.RepoModel;

/**
 * Created by lsitec101.macedo on 17/05/18.
 */

public class RepoAdapter {

    private final RepoAdapterOnClickHandler mClickHandler;


    public interface RepoAdapterOnClickHandler {
        void onClick(RepoModel movie);
    }

    public RepoAdapter(RepoAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }
}
