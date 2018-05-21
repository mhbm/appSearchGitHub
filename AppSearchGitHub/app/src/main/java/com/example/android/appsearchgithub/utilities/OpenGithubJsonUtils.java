package com.example.android.appsearchgithub.utilities;

import com.example.android.appsearchgithub.data.RepoModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lsitec101.macedo on 21/05/18.
 */

public class OpenGithubJsonUtils {

    public static RepoModel[] getRepoFromJson(String repoJsonString) throws JSONException {
        RepoModel[] resultRepoData;

        JSONObject repoJson = new JSONObject(repoJsonString);

        JSONArray repoJsonArray = repoJson.getJSONArray("items");

        resultRepoData = new RepoModel[repoJsonArray.length()];

        for (int i = 0; i < repoJsonArray.length(); i++) {

            JSONObject repo = repoJsonArray.getJSONObject(i);

            RepoModel repoModel = new RepoModel();

            repoModel.setNameAuthor(repo.getString("full_name"));
            repoModel.setNameRepo(repo.getString("name"));
            repoModel.setDescRepo(repo.getString("description"));
            repoModel.setNumberForks(repo.getInt("forks_count"));
            repoModel.setNumberStar(repo.getInt("stargazers_count"));
//            repoModel.setPhotoAuthor(repo.getString());

            resultRepoData[i] = repoModel;
        }
        return  resultRepoData;

    }
}
