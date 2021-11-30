package com.example.cartoonsearch;

import com.google.gson.annotations.SerializedName;

public class CartoonDetails {

    @SerializedName("mal_id")
    private String malId;

    @SerializedName("url")
    private String url;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("airing")
    private String airing;

    @SerializedName("synopsis")
    private String synopsis;

    @SerializedName("type")
    private String type;

    @SerializedName("episodes")
    private String episodes;

    @SerializedName("start_date")
    private String startDate;

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("members")
    private String members;

    @SerializedName("rated")
    private String rated;

    @SerializedName("score")
    private String score;

    public String getMalId() {
        return malId;
    }

    public void setMalId(String malId) {
        this.malId = malId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAiring() {
        return airing;
    }

    public void setAiring(String airing) {
        this.airing = airing;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
