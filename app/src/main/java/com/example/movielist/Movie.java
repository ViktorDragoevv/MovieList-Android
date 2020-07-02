package com.example.movielist;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String movieYear;
    private String movieName;
    private String movieAuthor;
    private String movieGenre;
    private float ratingB;


    public Movie( String movieYear,String movieName, String movieAuthor, String movieGenre,float ratingB) {

        this.movieName = movieName;
        this.movieAuthor = movieAuthor;
        this.movieYear = movieYear;
        this.movieGenre = movieGenre;
        this.ratingB=ratingB;
    }
    public Movie(){}

    protected Movie(Parcel in) {

        movieName = in.readString();
        movieAuthor = in.readString();
        movieYear = in.readString();
        movieGenre = in.readString();
        ratingB = in.readFloat();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public float getRatingB() {
        return ratingB;
    }

    public void setRatingB(float ratingB) {
        this.ratingB = ratingB;
    }


    @Override
    public String toString() {
        return "Movie{" +

                ", movieName='" + movieName + '\'' +
                ", movieAuthor='" + movieAuthor + '\'' +
                "movieYear='" + movieYear + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", ratingB=" + ratingB +
                '}';
    }

    public String getMovieYear() {
        return movieYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieAuthor() {
        return movieAuthor;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieAuthor(String movieAuthor) {
        this.movieAuthor = movieAuthor;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(movieName);
        dest.writeString(movieAuthor);
        dest.writeString(movieYear);
        dest.writeString(movieGenre);
        dest.writeFloat(ratingB);
    }
}

