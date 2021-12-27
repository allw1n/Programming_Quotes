package com.example.programmingquotes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PQViewHolder extends RecyclerView.ViewHolder {

    private TextView txtPQ, txtPQA;
    private String authorTxt;

    public PQViewHolder(@NonNull View itemView) {
        super(itemView);

        txtPQ = itemView.findViewById(R.id.txtPQ);
        txtPQA = itemView.findViewById(R.id.txtPQA);
    }

    public void bind(ProgrammingQuote programmingQuote) {
        txtPQ.setText(programmingQuote.getEn());
        authorTxt = " - " + programmingQuote.getAuthor();
        txtPQA.setText(authorTxt);
    }

    public TextView getTxtPQ() {
        return txtPQ;
    }

    public void setTxtPQ(TextView txtPQ) {
        this.txtPQ = txtPQ;
    }

    public TextView getTxtPQA() {
        return txtPQA;
    }

    public void setTxtPQA(TextView txtPQA) {
        this.txtPQA = txtPQA;
    }
}
