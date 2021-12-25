package com.example.programmingquotes;

import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuotesInterface {

    @GET("Quotes")
    Call<List<ProgrammingQuotes>> getQuotes();
}
