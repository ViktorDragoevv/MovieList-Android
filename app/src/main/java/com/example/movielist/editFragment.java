package com.example.movielist;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class editFragment extends DialogFragment  {
    Button btn;
    EditText name;
    EditText author;
    EditText year;
    EditText genre;
    InserRemoveInterface lisener;
    RatingBar rb;


    public static editFragment newInstance(int position) {
        editFragment fragment = new editFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }
    public editFragment() {
        // Required empty public constructor
    }
   /* public static editFragment newInstance(int position) {
        return new editFragment();
    }*/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        lisener = (InserRemoveInterface) context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("sss",Integer.toString(getArguments().getInt("position",-1)));
        return inflater.inflate(R.layout.fragment_edit, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Movie movie =new Movie();
        try {


             movie = Repository.getMovieByPossition(getArguments().getInt("position", -1));
            Log.d("sss","s");
        } catch (Exception e) {
            e.printStackTrace();
        }
        btn=view.findViewById(R.id.editBTN);
        name=view.findViewById(R.id.editTitle);
        author=view.findViewById(R.id.editAuth);
        year=view.findViewById(R.id.editYear);
        genre=view.findViewById(R.id.editGenre);
        rb=view.findViewById(R.id.editRB);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Movie movie = new Movie(name.getText().toString(),author.getText().toString(),year.getText().toString(),genre.getText().toString(),rb.getRating());
               // Movie movie = new Movie(author.getText().toString(),name.getText().toString(),year.getText().toString(),genre.getText().toString(),rb.getRating());
                Movie movie=new Movie(year.getText().toString(),name.getText().toString(),author.getText().toString(),genre.getText().toString(),rb.getRating());
                Log.d("ccccccc",movie.toString());
                Log.d("author",author.getText().toString());
                lisener.onEditFinish(movie,(getArguments().getInt("position",-1)));
                dismiss();
            }
        });

        //name.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        name.setText(movie.getMovieName());
        author.setText(movie.getMovieAuthor());
        year.setText(movie.getMovieYear());
        genre.setText(movie.getMovieGenre());
        rb.setRating(movie.getRatingB());











        //Log.d("sss",Integer.toString(getArguments().getInt("position",-1)));

    }


}
