package com.example.programmingquotes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuotesInterface {

    @GET("Quotes")
    Call<List<ProgrammingQuote>> getQuotes();
}
