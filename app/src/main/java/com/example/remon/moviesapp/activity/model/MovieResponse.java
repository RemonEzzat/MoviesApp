package com.example.remon.moviesapp.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

   // vars
    @SerializedName ( "page" )
    private int Page;
    @SerializedName ( "results" )
    private List<MoviesModel>results;
    @SerializedName ( "total_results" )
    private int totalResults;
    @SerializedName ( "total_pages" )
    private int totalPages;




    public MovieResponse(int page , List <MoviesModel> results , int totalResults , int totalPages) {

        Page = page;
        this.results = results;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }  // Constructor


    // getter and setter

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public List <MoviesModel> getResults() {
        return results;
    }

    public void setResults(List <MoviesModel> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
