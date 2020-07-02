package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InserRemoveInterface {
RecyclerView recyclerView;
Button insertButton;
private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView=findViewById(R.id.reView);
        //insertButton=findViewById(R.id.insertBT);
        ArrayList<Movie> movie = new ArrayList<Movie>();
        movie=Repository.getMovie();
        adapter= new CustomAdapter(movie);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = findViewById(R.id.insertButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                BlankFragment addMovieFragment = BlankFragment.newInstance();
                addMovieFragment.show(fm, "fragment_add_movie");
            }
        });









    }


    @Override
    public void onFinishAddDialog(Movie movie) {
        adapter.AddMovie(movie);
    }

    @Override
    public void onEditFinish(Movie movie,int position) {
        adapter.EditMovie(movie,position);
    }


}
