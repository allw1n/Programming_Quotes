package com.example.programmingquotes;

import com.google.gson.annotations.SerializedName;

public class ProgrammingQuote {

    @SerializedName("author")
    private String author;

    @SerializedName("en")
    private String en;

    public String getAuthor() {
        return author;
    }

    public String getEn() {
        return en;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
