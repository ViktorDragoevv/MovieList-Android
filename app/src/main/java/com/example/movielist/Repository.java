package com.example.movielist;

import android.util.Log;

import java.util.ArrayList;

public class Repository {



    public static ArrayList<Movie>movielist=new ArrayList<>();
    public static ArrayList<Movie> getMovie (){

         //ArrayList<Movie>movielist=new ArrayList<Movie>();
        movielist.add(new Movie("2020","Diamonds","netflix","criminal",2));
        movielist.add(new Movie("2020","heist money","netflix","criminal",3));
        movielist.add(new Movie("to","Click","here","edit",3));
        movielist.add(new Movie("to","Long","click","delete",3));
        movielist.add(new Movie("2020","WestWorld","HBO","adventure,criminal",3));

       // movielist.add(new Movie("2020","heist money","nekoisi","criminal",3));

       // movielist.add(new Movie("2020","heist money","nekoisi","criminal",3));



        return movielist;

    }

    public static Movie getMovieByPossition(int position){

        Log.d("sss",movielist.toString());
        return movielist.get(position);

    }
    public void EditMovie(Movie movie,int possition)
    {

        movielist.set(possition,movie);




    }

}
