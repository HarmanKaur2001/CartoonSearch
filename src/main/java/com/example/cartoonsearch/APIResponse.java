package com.example.cartoonsearch;



import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class APIResponse {
    @SerializedName("last_page")
    private String lastPage;

    @SerializedName("request_cached")
    private String requestCached;

    @SerializedName("request_hash")
    private String requestHash;


    //result is searched from cartoon class
    @SerializedName("result")
    private ArrayList<Cartoon> result;

    public ArrayList<Cartoon> getSearch() {
        return result;
    }

    public ArrayList<Cartoon> getSearchSorted()
    {
        //Arrays.sort(result);
        return result;
    }

    public void setSearch(ArrayList<Cartoon> search) {
        this.result = result;
    }

    public String getRequestCached() {
        return requestCached;
    }

    public String getLastPage() {
        return lastPage;
    }

    public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
    }

    public void setRequestCached(String requestCached) {
        this.requestCached = requestCached;
    }

    public String getRequestHash() {
        return requestHash;
    }

    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    public ArrayList<Cartoon> getResult() {
        return result;
    }

    public void setResult(ArrayList<Cartoon> result) {
        this.result = result;
    }
}

