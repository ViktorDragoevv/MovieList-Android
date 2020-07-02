package com.example.movielist;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder extends RecyclerView.ViewHolder {

    public static View btn;
    private TextView name;
private TextView year;
private TextView genre;
private TextView author;
private RatingBar rb;
//private Button btn;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.MovieName);
        author=itemView.findViewById(R.id.author);
        year=itemView.findViewById(R.id.year);
        genre=itemView.findViewById(R.id.genre);

        rb=itemView.findViewById(R.id.ratingBar2);


    }

    public TextView getName() {
        return name;
    }


    public RatingBar getRb() {
        return rb;
    }

    public void setRb(float rb) {
        this.rb.setRating(rb);
    }

    public void setName(String name) {
        this.name.setText(name);
    }
    public void setAuthor(String author) {
        this.author.setText(author);
    }

    public TextView getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year.setText(year);
    }

    public TextView getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.setText(genre);
    }

    public TextView getAuthor() {
        return author;
    }


}
