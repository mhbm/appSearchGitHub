package com.example.android.appsearchgithub.adapter;

import android.content.Context;
import android.database.Cursor;

import com.example.android.appsearchgithub.data.RepoModel;

/**
 * Created by lsitec101.macedo on 17/05/18.
 */

public class RepoAdapter {

    private final RepoAdapterOnClickHandler mClickHandler;

    private RepoModel[] mRepoList;
    private Context mContext;

    private Cursor mCursor;

    public RepoAdapter(RepoAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    public interface RepoAdapterOnClickHandler {
        void onClick(RepoModel movie);
    }

//    public class RepoAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//
//    }


}
