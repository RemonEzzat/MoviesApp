package com.example.remon.moviesapp.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.remon.moviesapp.activity.activity.MoviesDetails;
import com.example.remon.moviesapp.activity.model.MoviesModel;
import com.example.remon.retrofitexample.R;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter <MoviesAdapter.MovieViewHolder> {

    // vars
    private final List <MoviesModel> moviesModels;
    private int rowLayout;
    private Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    } // click on item

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        CardView moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView imageView;


        public MovieViewHolder(View v) {
            super ( v );
            moviesLayout = v.findViewById ( R.id.movies_layout );
            movieTitle = v.findViewById ( R.id.title );
            data = v.findViewById ( R.id.subtitle );
            movieDescription = v.findViewById ( R.id.description );
            rating = v.findViewById ( R.id.rating );
            itemView.setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick(View v) {
                    if ( mListener != null ) {
                        int position = getAdapterPosition ( );
                        if ( position != RecyclerView.NO_POSITION ) {
                            mListener.onItemClick ( position );

                        }
                    }
                }
            } );
        }
    } // view holder class

    public MoviesAdapter(List <MoviesModel> moviesModels , int rowLayout , Context context) {
        this.moviesModels = moviesModels;
        this.rowLayout = rowLayout;
        this.context = context;
    } // constructor

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from ( parent.getContext ( ) ).inflate ( rowLayout , parent , false );
        return new MovieViewHolder ( view );
    } // on create function

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder , final int position) {

        holder.movieTitle.setText ( moviesModels.get ( position ).getTitle ( ) );
        holder.data.setText ( moviesModels.get ( position ).getReleaseDate ( ) );
        holder.movieDescription.setText ( moviesModels.get ( position ).getOverView ( ) );
        holder.rating.setText ( moviesModels.get ( position ).getVoteAverage ( ).toString ( ) );

        holder.itemView.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {

                Intent detailIntent = new Intent ( context , MoviesDetails.class );
                MoviesModel clickedItem = moviesModels.get ( position );
                Bundle bundle = new Bundle ( );
                bundle.putSerializable ( "movie" , clickedItem );
                detailIntent.putExtras ( bundle );
                detailIntent.addFlags ( Intent.FLAG_ACTIVITY_NEW_TASK );
                context.startActivity ( detailIntent );
            }
        } );

    } // on bind function

    @Override
    public int getItemCount() {
        return moviesModels.size ( );
    } // get items count functions
}
