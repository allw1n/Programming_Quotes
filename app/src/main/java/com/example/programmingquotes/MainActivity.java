package com.example.programmingquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private final List<ProgrammingQuote> mProgrammingQuotes = new ArrayList<>();
    private PQAdapter mPQAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.pqRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mPQAdapter = new PQAdapter(this, mProgrammingQuotes);
        mRecyclerView.setAdapter(mPQAdapter);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        requestQuotes();
    }

    private void requestQuotes() {
        QuotesInterface quotesInterface = RetrofitServiceGenerator.createRetrofitService(QuotesInterface.class);
        Call<List<ProgrammingQuote>> call = quotesInterface.getQuotes();
        call.enqueue(new Callback<List<ProgrammingQuote>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<ProgrammingQuote>> call, @NonNull Response<List<ProgrammingQuote>> response) {
                if (response.isSuccessful()) {
                    /*for (ProgrammingQuote programmingQuote : response.body()) {
                        mProgrammingQuotes.add(programmingQuote);
                    }
                    mPQAdapter.notifyDataSetChanged();*/

                    progressBar.setVisibility(View.GONE);

                    mProgrammingQuotes.clear();
                    assert response.body() != null;
                    mProgrammingQuotes.addAll(response.body());
                    mPQAdapter.notifyDataSetChanged();
                }
                else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProgrammingQuote>> call, @NonNull Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}