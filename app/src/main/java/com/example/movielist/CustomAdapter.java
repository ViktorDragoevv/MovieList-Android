package com.example.movielist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private List<Movie> movies;
    ViewHolder holder;
    Button btn;
    private Activity activity;

    public CustomAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);


        View contactView = inflater.inflate(R.layout.movie_item , parent, false);


        ViewHolder viewHolder = new ViewHolder((contactView));

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Movie movie = movies.get(position);

        holder.setName(movie.getMovieName());
        holder.setAuthor(movie.getMovieAuthor());
        holder.setYear(movie.getMovieYear());
        holder.setGenre(movie.getMovieGenre());


        holder.setRb(movie.getRatingB());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,  "Click longer to delte:"+movie.getMovieName() + ": " + movie.getMovieAuthor()  + ": " + movie.getMovieYear() + ": " + movie.getMovieGenre() ,  Toast.LENGTH_SHORT).show();
                //Intent intent =new Intent();
                //intent.putExtra("possition",position);
               // activity.startActivity(intent);


                FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
                editFragment editMovieFragment = editFragment.newInstance(position);
                editMovieFragment.show(fm, "fragment_edit_movie");

            }
        });



        int currentPossition=position;
        final Movie mve = movies.get(position);
      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //removeItem(mve);
                Toast.makeText(context,"Click One more time to delete:")();
            }
        });*/


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                removeItem(mve);
                return true;
            }
        });
    }

    private void removeItem(Movie mve) {
        int possitionn= movies.indexOf(mve);
        movies.remove(possitionn);
        notifyItemRemoved(possitionn);
    }

    public void AddMovie(Movie movie)
    {
        movies.add(getItemCount(), movie);
        notifyItemInserted(getItemCount());
        //System.out.println(movies);

    }

    public void EditMovie(Movie movie,int position)
    {

        movies.set(position,movie);

        notifyItemChanged(position, getItemCount());


    }
    private void deleteItem(int position) {
        movies.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, movies.size());

        holder.itemView.setVisibility(View.GONE);
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }
}
