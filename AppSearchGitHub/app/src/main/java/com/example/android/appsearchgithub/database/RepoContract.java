package com.example.android.appsearchgithub.database;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by lsitec101.macedo on 21/05/18.
 */

public class RepoContract {

    public static final String AUTHORITY = "com.example.android.appsearchgithub";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final String PATH_REPOS = "repos";

    public static final class RepoEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_REPOS).build();

        public static final String TABLE_NAME = "repos";

        public static final String COLUMN_NAMEAUTHOR = "nameAuthor";
        public static final String COLUMN_DESCREPO = "descRepo";
        public static final String COLUMN_NAMEREPO = "nameRepo";
        public static final String COLUMN_NUMBERSTAR = "numberStar";
        public static final String COLUMN_NUMBERFORK = "numberFork";

    }

}
