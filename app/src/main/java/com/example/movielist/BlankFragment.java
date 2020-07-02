package com.example.movielist;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

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
public class BlankFragment extends DialogFragment implements View.OnClickListener {
Button btn;
EditText name;
EditText author;
EditText year;
EditText genre;
InserRemoveInterface lisener;
RatingBar rb;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        lisener = (InserRemoveInterface) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn=view.findViewById(R.id.button);
        name=view.findViewById(R.id.Name);
        author=view.findViewById(R.id.author);
        year=view.findViewById(R.id.year);
        genre=view.findViewById(R.id.genre);
        rb=view.findViewById(R.id.ratingBar);
        btn.setOnClickListener(this);

       // name.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onClick(View v) {
        //Movie movie = new Movie(name.getText().toString(),author.getText().toString(),year.getText().toString(),genre.getText().toString(),rb.getRating());
       // Movie movie = new Movie(author.getText().toString(),name.getText().toString(),year.getText().toString(),genre.getText().toString(),rb.getRating());
        Movie movie=new Movie(year.getText().toString(),name.getText().toString(),author.getText().toString(),genre.getText().toString(),rb.getRating());
        lisener.onFinishAddDialog(movie);

        dismiss();
    }
}
