package com.example.android.appsearchgithub.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lsitec101.macedo on 17/05/18.
 */

public class RepoModel implements Parcelable {

    private static final String BASE_URL = "https://api.github.com/search/repositories?q=language:Kotlin&sort=stars&page=1";
    private String nameRepo;
    private String descRepo;
    private String nameAuthor;
    private String photoAuthor;
    private int numberStar;
    private int numberForks;


    public String getNameRepo() {
        return nameRepo;
    }

    public void setNameRepo(String nameRepo) {
        this.nameRepo = nameRepo;
    }

    public String getDescRepo() {
        return descRepo;
    }

    public void setDescRepo(String descRepo) {
        this.descRepo = descRepo;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getPhotoAuthor() {
        return photoAuthor;
    }

    public void setPhotoAuthor(String photoAuthor) {
        this.photoAuthor = photoAuthor;
    }

    public int getNumberStar() {
        return numberStar;
    }

    public void setNumberStar(int numberStar) {
        this.numberStar = numberStar;
    }

    public int getNumberForks() {
        return numberForks;
    }

    public void setNumberForks(int numberForks) {
        this.numberForks = numberForks;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nameRepo);
        dest.writeString(this.descRepo);
        dest.writeString(this.nameAuthor);
        dest.writeString(this.photoAuthor);
        dest.writeInt(this.numberStar);
        dest.writeInt(this.numberForks);
    }

    public RepoModel() {
    }

    protected RepoModel(Parcel in) {
        this.nameRepo = in.readString();
        this.descRepo = in.readString();
        this.nameAuthor = in.readString();
        this.photoAuthor = in.readString();
        this.numberStar = in.readInt();
        this.numberForks = in.readInt();
    }

    public static final Creator<RepoModel> CREATOR = new Creator<RepoModel>() {
        @Override
        public RepoModel createFromParcel(Parcel source) {
            return new RepoModel(source);
        }

        @Override
        public RepoModel[] newArray(int size) {
            return new RepoModel[size];
        }
    };
}
