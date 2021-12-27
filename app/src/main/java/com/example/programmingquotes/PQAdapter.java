package com.example.programmingquotes;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PQAdapter extends RecyclerView.Adapter<PQViewHolder> {

    private Context mContext;
    private List<ProgrammingQuotes> mProgrammingQuotes;

    public PQAdapter(Context context, List<ProgrammingQuotes> programmingQuotes) {
        mContext = context;
        mProgrammingQuotes = programmingQuotes;
    }

    @NonNull
    @Override
    public PQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pq_item, parent, false);
        return new PQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PQViewHolder holder, int position) {
        ProgrammingQuotes programmingQuotes =mProgrammingQuotes.get(position);
        holder.bind(programmingQuotes);
    }

    @Override
    public int getItemCount() {
        return mProgrammingQuotes.size();
    }
}
