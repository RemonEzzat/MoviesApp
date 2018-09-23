package com.example.remon.moviesapp.activity.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MoviesModel implements Serializable {

    // var
    @SerializedName ( "poster_path" )
    private String PosterPath;
    @SerializedName ( "adult" )
    private boolean Adult;
    @SerializedName ( "overview" )
    private String OverView;
    @SerializedName ( "release_date" )
    private String ReleaseDate;
    @SerializedName ( "genre_ids" )
    private List <Integer>genreIds;
    @SerializedName ( "id" )
    private Integer id;
    @SerializedName ( "original_title" )
    private String originalTitle;
    @SerializedName ( "title" )
    private String Title;
    @SerializedName ( "original_language" )
    private String originalLanguage;
    @SerializedName ( "backdrop_path" )
    private String backdropPath;
    @SerializedName ( "popularity" )
    private Double popularity;
    @SerializedName ( "video" )
    private Boolean video;
    @SerializedName ( "vote_count" )
    private Integer voteCount;
    @SerializedName ( "vote_average" )
    private Double voteAverage;



    public MoviesModel(String posterPath , boolean adult , String overView , String releaseDate , List <Integer> genreIds ,
                       Integer id , String originalTitle , String title , String originalLanguage , String backdropPath ,
                       Double popularity , Boolean video , Integer voteCount , Double voteAverage) {
        PosterPath = posterPath;
        Adult = adult;
        OverView = overView;
        ReleaseDate = releaseDate;
        this.genreIds = genreIds;
        this.id = id;
        this.originalTitle = originalTitle;
        Title = title;
        this.originalLanguage = originalLanguage;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.video = video;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    } // Constructor


    // getter and setter to get a value in main activity

    public String getPosterPath() {
        return PosterPath;
    }

    public void setPosterPath(String posterPath) {
        PosterPath = posterPath;
    }

    public boolean isAdult() {
        return Adult;
    }

    public void setAdult(boolean adult) {
        Adult = adult;
    }

    public String getOverView() {
        return OverView;
    }

    public void setOverView(String overView) {
        OverView = overView;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public List <Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List <Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
